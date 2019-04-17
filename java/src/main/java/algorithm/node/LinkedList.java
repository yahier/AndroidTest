package algorithm.node;


/**
 * 得到一个自建的链表从头到尾的值分别是[1,2,3,4,5]
 */
public class LinkedList {
    //头结点，只参与引用，算作链表数据之外的部分
    private static Node head;

    public static void initOrder() {
        int size = 5;
        Node temp = null;
        Node tail = null;
        for (int i = size; i > 0; i--) {
            //尾巴
            if (i == size) {
                tail = new Node(i, null);
            }

            //中间部分
            if (i < size && i != 1) {
                if (temp == null) {
                    temp = new Node(i, tail);
                } else {
                    temp = new Node(i, temp);
                }
            }

            //头部
            if (i == 1) {
                head = new Node(i, temp);
            }

        }
    }

    /**
     * 初始化无序链表
     */
    public static void initNoOrder() {
        int size = 5;
        Node temp = null;
        Node tail = null;
        for (int i = size; i > 0; i--) {
            //尾巴
            if (i == size) {
                tail = new Node(i, null);
            }

            //中间部分
            if (i < size && i != 1) {
                if (temp == null) {
                    temp = new Node(6, tail);
                } else {
                    temp = new Node(6, temp);
                }
            }

            //头部
            if (i == 1) {
                head = new Node(i, temp);
            }

        }
    }


    public static Node getHead() {
        return head;
    }


}
