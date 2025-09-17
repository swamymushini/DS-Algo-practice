package com.hld.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.util.Util;

public class ConsistentHashingSolution {
	public class Pair<K, V> {
		private K key;
		private V value;

		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public void setValue(V value) {
			this.value = value;
		}
	}

	private ArrayList<Integer> answers;
	/* each pair corresponds to : ( location, serverID ) */
	private Map<Integer, String> locationToServerMapping;
	/* each pair corresponds to : ( serverID, <usernames> ) */
	private Map<String, List<Pair<String, Integer>>> serverToKeyMappings;

	private int userHash(String username, int hashKey) {
		final int p = hashKey;
		final int n = 360;
		long hashCode = 0;
		long p_pow = 1;
		for (int i = 0; i < username.length(); i++) {
			char character = username.charAt(i);
			hashCode = (hashCode + (character - 'A' + 1) * p_pow) % n;
			p_pow = (p_pow * p) % n;
		}
		return (int) (hashCode);
	}

	private int assignRequest(String keyname, int hashKey) {
		if (locationToServerMapping.size() == 0) {
			return -1;
		}
		int keyLocation = userHash(keyname, hashKey);
		Map.Entry<Integer, String> it = locationToServerMapping.entrySet().stream()
				.filter(e -> e.getKey() >= keyLocation).findFirst()
				.orElse(locationToServerMapping.entrySet().stream().findFirst().get());
		/*
		 * when no server to right on the ring, assign the first server from start of
		 * the ring
		 */
		String serverID = it.getValue();
		serverToKeyMappings.computeIfAbsent(serverID, k -> new ArrayList<>()).add(new Pair<>(keyname, hashKey));
		return keyLocation;
	}

	private void findRequestsToServe(int serverLocation, int hashKey) {
		if (serverToKeyMappings.size() == 0) {
			/* No requests to serve */
			return;
		}
		/*
		 * we need to find the requests which can now possibly be redirected to the
		 * added server
		 */
		/*
		 * doing +1 because otherwise we'll get the location of the newly added server
		 */
		Map.Entry<Integer, String> it = locationToServerMapping.entrySet().stream()
				.filter(e -> e.getKey() > serverLocation).findFirst()
				.orElse(locationToServerMapping.entrySet().stream().findFirst().get());
		String serverID = it.getValue();
		/* these are the usernames which can possibly be redirected */
		List<Pair<String, Integer>> keynames = serverToKeyMappings.getOrDefault(serverID, new ArrayList<>());
		serverToKeyMappings.remove(serverID);
		for (Pair<String, Integer> entry : keynames) {
			/* may or may not get reassigned */
			assignRequest(entry.getKey(), entry.getValue());
		}
	}

	public static void main(String[] args) {

		String[] A = { "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "ADD", "ASSIGN",
				"ASSIGN", "ASSIGN", "ADD", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN", "ASSIGN",
				"REMOVE", "ASSIGN", "ASSIGN", "ASSIGN", "REMOVE", "ASSIGN", "ASSIGN" };

		String[] B = { "INDIA", "XXWK", "HLFK", "XPUZ", "RUSSIA", "HYSP", "AYMS", "NZYJ", "CHINA", "MCVT", "SZXJ",
				"RPXJ", "GERMANY", "XXYV", "NECG", "MTAI", "INDIA", "UAQR", "PUZE", "LISG", "RUSSIA", "ZMYR", "NAKS",
				"RVDV", "CHINA", "EZUH", "OWCR" };

		int[] C = { 211, 181, 919, 383, 571, 127, 977, 97, 271, 127, 751, 79, 89, 571, 641, 743, 79, 53, 419, 727, 5,
				757, 191, 823, 787, 337, 827 };

		ArrayList<Integer> solve = new ConsistentHashingSolution().solve(A, B, C);
		System.out.println(solve);
	}

	private int addServer(String serverID, int hashKey) {
		int firstLocation = userHash(serverID, hashKey);
		locationToServerMapping.put(firstLocation, serverID);
		findRequestsToServe(firstLocation, hashKey);
		return serverToKeyMappings.getOrDefault(serverID, new ArrayList<>()).size();
	}

	private int removeServer(String serverID, int hashKey) {
		for (Iterator<Map.Entry<Integer, String>> it = locationToServerMapping.entrySet().iterator(); it.hasNext();) {
			Map.Entry<Integer, String> entry = it.next();
			if (entry.getValue().equals(serverID)) {
				it.remove();
				break;
			}
		}
		List<Pair<String, Integer>> keynamesToReassign = serverToKeyMappings.getOrDefault(serverID,
				Collections.emptyList());
		serverToKeyMappings.remove(serverID);
		for (Pair<String, Integer> keyname : keynamesToReassign) {
			assignRequest(keyname.getKey(), keyname.getValue());
		}
		return keynamesToReassign.size();
	}

	void performOperation(String A, String B, int C) {
		String operation = A;
		if (operation.equals("ADD")) {
			String serverID = B;
			answers.add(addServer(serverID, C));
		} else if (operation.equals("REMOVE")) {
			String serverID = B;
			answers.add(removeServer(serverID, C));
		} else if (operation.equals("ASSIGN")) {
			String keyname = B;
			answers.add(assignRequest(keyname, C));
		}
	}

	public ArrayList<Integer> solve(String[] A, String[] B, int[] C) {
		answers = new ArrayList<Integer>();
		locationToServerMapping = new TreeMap<Integer, String>();
		serverToKeyMappings = new HashMap<String, List<Pair<String, Integer>>>();
		for (int i = 0; i < A.length; i++) {
			performOperation(A[i], B[i], C[i]);
		}
		return answers;
	}
}