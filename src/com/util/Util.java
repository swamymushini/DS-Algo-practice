package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.linkedlist.DetectLoop;
import com.linkedlist.DoubleNode;
import com.linkedlist.ListNode;

public class Util {

	public static void main(String[] args) {

		DoubleNode list = Util.prepareDoublyLinkList(new int[] { 1, 2, 3, 4, 5, 6 });
		list.delete(3);
		Util.printDoubleLinkedList(list);
	}

	public static void printArray(int[] arr) {

		for (int i : arr) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}

	public static void printArrayList(List<Integer> list) {

		for (int i : list) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}

	public static void print2DArray(int[][] arr) {

		for (int[] i : arr) {

			for (int j : i) {
				System.out.print(j);
				System.out.print(" ");
			}

			System.out.println();
		}

	}

	public static int[][] listtoArray(ArrayList<int[]> arr) {

		int[][] arr1 = new int[arr.size()][2];

		for (int j = 0; j < arr.size(); j++) {
			arr1[j] = arr.get(j);
		}

		return arr1;
	}

	public static int[] arrayListtoArray(ArrayList<Integer> arr) {

		int[] arr1 = new int[arr.size()];

		for (int j = 0; j < arr.size(); j++) {
			arr1[j] = arr.get(j);
		}

		return arr1;
	}

	public static ArrayList<Integer> createArrayList(int[] a) {
		ArrayList<Integer> array_list = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++)
			array_list.add(new Integer(a[i]));

		return array_list;
	}

	public static ArrayList<ArrayList<Integer>> listtoArray(int[][] arr) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < arr.length; i++) {

			int[] js = arr[i];

			ArrayList<Integer> temp = new ArrayList<Integer>();

			for (int j = 0; j < js.length; j++) {
				temp.add(js[j]);
			}

			res.add(temp);

		}

		return res;
	}

	public static int[][] nestedListtoArray(ArrayList<ArrayList<Integer>> arr) {

		int col = 3;

		int[][] arr1 = new int[arr.size()][col];

		for (int i = 0; i < arr.size(); i++) {

			int[] inArr = new int[col];

			List<Integer> otArr = arr.get(i);

			for (int j = 0; j < col; j++) {
				inArr[j] = otArr.get(j);
			}

			arr1[i] = inArr;
		}

		return arr1;
	}

	public static int[] generateMaxInput() {
		int[] res = new int[8930];

		Random r = new Random();
		int low = 2000;
		int high = 9998339;

		for (int i = 0; i < res.length; i++) {
			res[i] = r.nextInt(high - low) + low;
		}
//		Arrays.sort(res);

		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
			System.out.print(" ");
		}

		System.out.println();

		return res;
	}

	public static ListNode prepareLinkedList(int[] arr) {

		ListNode head = new ListNode(arr[0]);
		ListNode temp = head;

		for (int i = 1; i < arr.length; i++) {
			temp.next = new ListNode(arr[i]);
			temp = temp.next;
		}

		return head;

	}

	public static DoubleNode prepareDoublyLinkList(int[] arr) {

		DoubleNode list = new DoubleNode();

		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}

		return list;

	}

	public static ListNode prepareLoopedList(int[] arr, int k) {

		ListNode head = new ListNode(arr[0]);
		ListNode temp = head;
		ListNode loopNode = null;

		for (int i = 1; i < arr.length; i++) {

			temp.next = new ListNode(arr[i]);

			if (i == k)
				loopNode = temp;

			temp = temp.next;
		}

		temp.next = loopNode;

		return head;
	}

	public static void printLinkedList(ListNode head) {
		ListNode detectCycle = new DetectLoop().detectCycle(head);

		if (detectCycle != null) {
			System.out.println("loop at " + detectCycle.val);
			return;
		}

		ListNode temp = head;

		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}

		System.out.println();
	}

	public static void printDoubleLinkedList(DoubleNode list) {

		DoubleNode temp = list.head;

		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}

		System.out.println();
	}
}
