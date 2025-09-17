

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	

	int curSize = 0;
	int size = 0;

	Map<Integer, Node> map = null;
	public  DoubleLinkedList dll = null;

	public LRUCache(int size) {
		curSize = 0;
		this.size = size;
		map = new HashMap<>(size);
		dll = new DoubleLinkedList();
	}

	public int get(int key) {

		Node node = map.get(key);

		if (node == null) {
			return -1;
		}
		
		dll.delete(node);
		dll.add(node);

		return node.value;
	}

	public void put(int key, int value) {

		Node node = new Node(key, value);

		if (map.containsKey(key)) {
			
			Node node2 = map.get(key);
			
			dll.delete(node2);
			map.remove(key);
			curSize--;
		}

		if (curSize >= size) {
			int key2 = dll.tail.key;
			dll.delete(dll.tail);
			map.remove(key2);
			curSize--;
		}

		dll.add(node);
		map.put(key, node);
		curSize++;
	}

	class DoubleLinkedList {

		Node head;
		Node tail;

		public DoubleLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void add(Node node) {

			if (head == null) {
				head = node;
				tail = node;
				return;
			}

			head.prev = node;
			node.next = head;
			head = node;
		}

		public void delete(Node node) {

			if (node.prev == null) {

				if (head.next == null) {
					head = null;
					tail = null;
					return;
				}

				Node temp = head.next;
				head.next = null;
				temp.prev = null;
				head = temp;
				return;
			}

			if (node.next == null) {
				Node temp = tail.prev;
				temp.next = null;
				tail = temp;
				return;
			}

			node.prev.next = node.next;
			node.next.prev = node.prev;

		}

	}

	class Node {

		Node prev;
		Node next;
		int key;
		int value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

}
