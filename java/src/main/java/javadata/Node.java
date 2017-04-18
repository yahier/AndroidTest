package javadata;

/**
 * Created by yahier on 17/4/18.
 */

public class Node {
    Node next;
    String name;

    public Node(String name) {
        this.name = name;
    }

    public static final void main(String[] args) {
        Node node1 = new Node("node1");
        Node node2 = new Node("node2");

        node1.next = node2;
        node2 = node1.next;

        System.out.print("name:" + node1.next.name);

    }
}
