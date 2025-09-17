import java.util.HashMap;
import java.util.Map;

class LFUCache {

	class DoubleList {
		Node head;
		Node tail;
	}

	class Node {

		Node prev;
		Node next = null;
		int val;
		int freq = 0;

		public Node(int val) {
			this.val = val;
		}
	}

	Node node;

	Map<Integer, Node> store = new HashMap<>();
	Map<Integer, DoubleList> freqMap = new HashMap<>();

	int cap = 0;
	int currCap = 0;

	public LFUCache(int capacity) {
		cap = capacity;
	}

	int minFreq = 0;

	public int get(int key) {
		Node node = store.get(key);

		if (node == null)
			return -1;

		DoubleList dbl = freqMap.get(node.freq);

		if (node.prev == null) {
			freqMap.remove(node.freq);
		} else {
			Node prev = node.prev;
			prev.next = node.next;
			if (node.next != null)
				node.next.prev = prev;
			else
				dbl.tail = prev;
		}

		node.freq = node.freq + 1;
		dbl = freqMap.get(node.freq);

		if (dbl == null) {
			dbl = new DoubleList();
			dbl.head = node;
			dbl.tail = node;
			freqMap.put(node.freq, dbl);
		} else {
			Node head = dbl.head;
			head.prev = node;
			node.next = head;
			dbl.head = node;
		}
		return node.val;
	}

	void remove() {
		int k = 0;
		DoubleList dbl = null;

		while (k < cap) {
			dbl = freqMap.get(k);
			if (dbl != null)
				break;
			k++;
		}

		Node tail = dbl.tail;

		if (tail.prev == null) {
			freqMap.remove(k);
			return;
		}

		Node prev = tail.prev;
		prev.next = null;
		dbl.tail = prev;

	}

	public void put(int key, int value) {

		if (store.get(key) != null) {
			Node node = store.get(key);
			node.val = value;
			return;
		}

		if (currCap + 1 >= cap) {
			remove();
		}

		Node node = new Node(value);
		store.put(key, node);
		currCap++;

		if (freqMap.get(0) == null) {
			DoubleList dbl = new DoubleList();
			dbl.head = node;
			dbl.tail = node;
			freqMap.put(0, dbl);
		} else {
			DoubleList dbl = freqMap.get(0);
			Node head = dbl.head;
			head.prev = node;
			node.next = head;
			dbl.head = node;
		}
	}
}

/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj =
 * new LFUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */