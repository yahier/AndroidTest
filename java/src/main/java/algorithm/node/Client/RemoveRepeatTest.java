package algorithm.node.Client;

import algorithm.node.LinkedList;
import algorithm.node.Node;

/**
 * 移除重复元素 todo 链表的构造有问题，最好先重建一个数据结构
 */
public class RemoveRepeatTest {

    public static void main(String[] args) {
        LinkedList.initNoOrder();
        Node head = LinkedList.getHead();

        //int tempValue;
        while (head != null) {
            //tempValue = head.value;

            System.out.println(head.value);
            head = head.next;
        }

        System.out.println("------");

        Node head1 = LinkedList.getHead();
        delete(head1, head1.next);
        delete(head1, head1.next);
        delete(head1, head1.next);

        while (head1 != null) {
            //tempValue = head.value;

            System.out.println(head1.value);
            head1 = head1.next;
        }

    }

    /**
     * @param node 被删除的结点
     */
    private static void delete(Node head, Node node) {
        System.out.println("想被删除的数据是:" + node.value);
        while (head.next != null) {
            //if语句
            if (head.value == node.value) {
                System.out.println("被删除的数据是:" + node.value);
                head.next = node.next.next;
                break;
            }
            head = head.next;
        }
    }
}
