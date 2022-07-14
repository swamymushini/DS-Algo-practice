package com.linkedlist;

public class DoubleNode {

	public int key;
	public int val;
	public DoubleNode prev;
	public DoubleNode next;

	public DoubleNode(int val) {
		this.val = val;
	}

	public DoubleNode(int key, int val) {
		this.val = val;
		this.key = key;
	}

	public DoubleNode() {
	}

	public DoubleNode tail;
	public DoubleNode head;

	public DoubleNode add(int val, int key) {
		DoubleNode node = new DoubleNode(val, key);
		return add(node);
	}

	public DoubleNode addtoHead(DoubleNode node) {

		if (head == null) {
			head = node;
			tail = node;
			return this;
		}

		node.next = head;
		head.prev = node;
		head = node;
		return this;
	}
	
	public DoubleNode delete(DoubleNode node) {

		if (node == null)
			return this;

		if (node.prev == null) {
			head = null;
			tail = null;
			return this;
		}

		if (node.next == null) {
			tail = node.prev;
			tail.next = null;
			return this;
		}

		node.prev.next = node.next;

		return this;
	}

	public DoubleNode add(int val) {
		DoubleNode node = new DoubleNode(val);
		return add(node);
	}

	private DoubleNode add(DoubleNode node) {

		if (head == null) {
			head = node;
			tail = node;
			return this;
		}

		tail.next = node;
		node.prev = tail;
		tail = node;
		return null;
	}

	public DoubleNode find(int val) {

		DoubleNode temp = head;
		while (temp != null) {

			if (temp.val == val)
				return temp;
			temp = temp.next;
		}

		return null;
	}

	public DoubleNode delete(int val) {

		DoubleNode node = find(val);
		return delete(node);
	}

	

}
