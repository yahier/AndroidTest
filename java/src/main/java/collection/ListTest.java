package collection;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

class ListTest {
    public static void main(String[] args) {
        //add();
        tString();

    }

    static void add() {
        List<Integer> list = new ArrayList<>();
        list.add(0, 10);
        System.out.println("add一个越界的item 数量是" + list.size());


        System.out.println("add一个越界的item 数量是" + list.get(0));
    }


    static void tString() {
        System.out.println("开始执行tString");
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("5");
        list.add("7");


        System.out.println(list.toString());

        String origin = list.toString();
        System.out.println("origin:" + origin);
        String encodeStr = URLEncoder.encode(origin);
        System.out.println("encodeStr:" + encodeStr);

        String origin1 = URLDecoder.decode(encodeStr);
        System.out.println("origin1:" + origin1);


        String encoderStr2 = "%22%5B1%2C2%2C3%2C4%2C5%2C6%5D%22";
        String origin2 = URLDecoder.decode(encoderStr2);
        System.out.println("origin2:" + origin2);

        String[] originArray = origin2.split(",");
        System.out.println("originArray.length "+originArray.length);
        for(int i=0;i<originArray.length;i++){
            System.out.println("item:"+originArray[i]);
        }




    }
}
