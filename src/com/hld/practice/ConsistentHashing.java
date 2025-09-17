package com.hld.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.util.Util;

public class ConsistentHashing {

	public static void main(String[] args) {
		String[] A = { "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN",
				"ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN",
				"REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN" };

		String[] B = { "INDIA", "VLVL", "OXXV", "HHGN", "RUSSIA", "AWNF", "SPHI", "FXKT", "CHINA", "JXZU", "BWPK",
				"JYWN", "GERMANY", "ZKYK", "HLQZ", "BRMS", "INDIA", "FMVA", "NPJO", "GACA", "RUSSIA", "ZMWM", "XVUA",
				"IDUW", "CHINA", "EHWW", "KROX" };

		int[] C = { 431, 563, 223, 761, 197, 409, 31, 223, 769, 619, 991, 613, 139, 797, 547, 821, 859, 131, 577, 269,
				2, 499, 599, 29, 449, 13, 337 };

		int[] solve = new ConsistentHashing().solve(A, B, C);
		Util.printArray(solve);

	}

	LinkedList<Server> servers = new LinkedList<>();
	Map<String, List<Integer>> requests = new HashMap<String, List<Integer>>();

	private int userHash(String name, int hashKey) {
		final int p = hashKey;
		final int n = 360;
		long hashCode = 0;
		long p_pow = 1;
		for (int i = 0; i < name.length(); i++) {
			char character = name.charAt(i);
			hashCode = (hashCode + (character - 'A' + 1) * p_pow) % n;
			p_pow = (p_pow * p) % n;
		}
		return (int) (hashCode);
	}

	public int[] solve(String[] A, String[] B, int[] C) {
		int len = A.length;

		int[] res = new int[len];

		for (int i = 0; i < A.length; i++) {

			switch (A[i]) {

			case "ADD":
				int userHash = userHash(B[i], C[i]);
				res[i] = addServer(userHash, B[i]);
				break;

			case "ASSIGN":
				userHash = userHash(B[i], C[i]);
				res[i] = assignRequest(userHash);
				break;

			case "REMOVE":
				res[i] = removeServer(B[i]);
				break;

			default:
				break;
			}
		}
		return res;
	}

	class Server {
		public int hashKey;
		public String name;
		public LinkedList<Integer> requests = new LinkedList<>();

		public Server(int hashKey, String name) {
			super();
			this.hashKey = hashKey;
			this.name = name;
		}

		public void addRequest(Integer requestHash) {
			requests.add(requestHash);
		}

		public void addRequests(LinkedList<Integer> requestHash) {
			requests.addAll(requestHash);
		}

		public void clearRequests() {
			requests.clear();
		}

	}

	int removeServer(String name) {

		Server removedServer = null;
		Iterator<Server> iterator = null;

		for (iterator = servers.iterator(); iterator.hasNext();) {
			Server server = iterator.next();
			if (server.name.equals(name)) {
				iterator.remove();
				removedServer = server;
				break;
			}
		}

		for (iterator = servers.iterator(); iterator.hasNext();) {
			Server server = iterator.next();
			if (server.hashKey >= removedServer.hashKey) {
				server.addRequests(removedServer.requests);
				return removedServer.requests.size();
			}
		}

		servers.getFirst().addRequests(removedServer.requests);

		return removedServer.requests.size();
	}

	int assignRequest(int hashCode) {

		for (Iterator<Server> iterator = servers.iterator(); iterator.hasNext();) {
			Server server = iterator.next();
			if (server.hashKey >= hashCode) {
				server.addRequest(hashCode);
				return hashCode;
			}
		}

		servers.getFirst().addRequest(hashCode);

		return hashCode;
	}

	int addServer(int hashCode, String name) {

		if (servers.size() == 0) {
			servers.add(new Server(hashCode, name));
			return 0;
		}

		int i = 0;
		Server nearestServer = null;
		for (Iterator<Server> iterator = servers.iterator(); iterator.hasNext();) {
			Server server = iterator.next();
			i++;
			if (server.hashKey >= hashCode) {
				nearestServer = server;
				break;
			}
		}

		Server actual = new Server(hashCode, name);

		if (nearestServer == null)
			nearestServer = servers.getFirst();

		if (actual.hashKey == nearestServer.hashKey) {
			servers.add(i - 1, actual);
			return actual.requests.size();
		} else if (actual.hashKey < nearestServer.hashKey)
			servers.add(i - 1, actual);
		else
			servers.add(i, actual);

		LinkedList<Integer> requests = new LinkedList<>(nearestServer.requests);
		nearestServer.clearRequests();

		LinkedList<Integer> actuals = new LinkedList<>();
		LinkedList<Integer> nearests = new LinkedList<>();

		if (actual.hashKey < nearestServer.hashKey) {
			interchangeRequests(actual, nearestServer, requests, actuals, nearests);
			actual.addRequests(actuals);
			nearestServer.addRequests(nearests);
		} else {
			interchangeRequests(nearestServer, actual, requests, actuals, nearests);
			actual.addRequests(nearests);
			nearestServer.addRequests(actuals);
		}

		return actual.requests.size();
	}

	void interchangeRequests(Server actual, Server nearest, List<Integer> requests, List<Integer> actuals,
			List<Integer> nearests) {

		for (Integer request : requests) {

			if (request > actual.hashKey && request <= nearest.hashKey)
				nearests.add(request);
			else
				actuals.add(request);
		}

	}

}
