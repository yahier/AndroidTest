package io;

public class MyLinkedList {
	class Node {
		Node next;
		int value;

		public Node(int value) {
			this.value = value;
		}

		public Node(Node next, int value) {
			this.value = value;
			this.next = next;

		}
	}

}
