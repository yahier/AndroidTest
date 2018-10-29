package collection;


import java.util.ArrayList;
import java.util.List;

public class ListGet {
    int[] a = {2, 4, 56, 7, 8, 9, 4};
    List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        ListGet lg = new ListGet();
        //lg.put();
        //lg.get();
        lg.t();
    }

    void put() {
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        list.add(0, 234);
    }

    void get() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }


    void t() {
        List list = new ArrayList();
        list.add(4);
        list.add(5);

        list.remove((Integer) 4);

        //list.remove(1);


        System.out.println("size:" + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ":" + list.get(i));
        }

    }


}
