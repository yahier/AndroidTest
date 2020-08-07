package string;

import java.text.SimpleDateFormat;

public class Format {
    static int a = 2;

    public static void main(String[] args) {
        //System.out.println(changeFormat(a));
        format();
    }

    static int changeFormat(int a) {
        if (a < 10) {
            a = Integer.parseInt("0" + a);
        }
        return a;

    }

    static void format() {
        String basic = "姓名：%2$s;   性别：%1$s;  分数：%3$d;";
        SimpleDateFormat sdf = new SimpleDateFormat(basic);
        String value = String.format(basic, "bingo","男",12);
        System.out.println("value is "+value);//value is 姓名：男;   性别：bingo;  分数：12;

    }

}
