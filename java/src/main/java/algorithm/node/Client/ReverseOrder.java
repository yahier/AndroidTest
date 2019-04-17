package algorithm.node.Client;

import algorithm.node.LinkedList;
import algorithm.node.Node;

/**
 * 将链表逆向。用双向链表来逆转就没有意义了，所以尝试用单向链表
 */
public class ReverseOrder {

    public static void main(String[] args) {
        print();
        reverse();
    }


    /**
     * 从head开始打印
     */
    public static void print() {
        Node head = LinkedList.getHead();
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    /**
     * 将链表逆转
     */
    public static void reverse() {
        Node head = LinkedList.getHead();
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        //代印出 头是1 尾巴是5
        System.out.println(head.value + " " + tail.value);

        Node second = getAhead(head, tail);
        System.out.println(second.value);

    }

    /**
     * 获取参数的前一个结点
     */
    private static Node getAhead(Node head, Node temp) {
        Node ahead = head.next;
        while (ahead.next.value != temp.value) {
            ahead = ahead.next;
            System.out.println("==");
        }
        return ahead;

    }
}
