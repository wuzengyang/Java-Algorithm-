package laiOfferTest;

import java.util.Map;

public class FirstNoRepeatingChar {
	
	public class Node {
		Character value;
		Node prev;
		Node next;
		
		public Node(Character value) {
			this.value = value;
			prev = null;
			next = null;
		}
	}
	
	private Node head;
	private Node tail;
	private Map<Character, Node> map;
	
	public void initial(char value) {
		Node node = new Node(value);
		head = node;
		tail = node;
		map.put(value, node);
	}
	
	public void read(Character value) {
		// three different case
		// case 1: this char is not in the map: not ever appeared
		// then we need to add it into both map and double linkedlist
		if (! map.containsKey(value)) {
			map.put(value, new Node(value));
			append(map.get(value));
			// case 2: this char is in the map and the value is not null : appeared once only
			// we need to remove it
		} else if (map.get(value) != null) {
			remove(map.get(value));
			map.put(value, null);
		} 
		// case 3: this char is in map and the value is null : appeared more than once
		// we do not need to do anything
	}
	
	public Node append(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		return node;
	}
	
	public Node remove(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		} 
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		
		if (head == node) {
			head = head.next;
		} 
		if (tail == node) {
			tail = tail.prev;
		} 
		node.next = null;
		node.prev = null;
		return node;
	}
	
	public Character firstNoRepeating() {
		return head.value;
	}

}
