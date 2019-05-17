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
        //lg.t();
        lg.testAddAll();
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


    void testAddAll() {
        List<String> data = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            data.add(String.valueOf(i));
        }
        data.addAll(getNewData());
        System.out.println(data.size());

        //以下方式的数据不能执行addAll方法
        //String[] strs = {"1", "2", "3", "4", "5"};
        //List<String> data2 = Arrays.asList(strs);
    }


    public List<String> getNewData() {
        List<String> data = new ArrayList<>();
        for (int i = 6; i < 11; i++) {
            data.add(String.valueOf(i));
        }


        return data;
    }

}
