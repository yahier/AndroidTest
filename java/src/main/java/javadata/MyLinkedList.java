package javadata;

public class MyLinkedList {
	class Node {
		Node next;
		int value;

		public Node(int value) {
			// TODO Auto-generated constructor stub
			this.value = value;
		}

		public Node(Node next, int value) {
			// TODO Auto-generated constructor stub
			this.value = value;
			this.next = next;

		}
	}
}
