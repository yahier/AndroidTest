package string;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

public class Format {
    static int a = 2;

    public static void main(String[] args) {
        //System.out.println(changeFormat(a));
        format();
        computeDoubleValue();
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
        String value = String.format(basic, "bingo", "男", 12);
        System.out.println("value is " + value);//value is 姓名：男;   性别：bingo;  分数：12;

    }

    /**
     * todo 注意 BigDecimal的参数需要为String,不能直接是double
     */
    static void computeDoubleValue() {
        double price = 1.52;
        int count = 3;

        /** 结果是 4.56**/
        BigDecimal value1 =  BigDecimal.valueOf(price);
        double result = value1.multiply(BigDecimal.valueOf(count)).doubleValue();
        System.out.println("11111 计算1值为result:"+result);

        /** 结果为4.560000000000000053290705182007513940334320068359375**/
        BigDecimal value2 = new BigDecimal(price);
        String result2 = value2.multiply(new BigDecimal(count)).toString();
        System.out.println("计算2值为result:"+result2);
    }

}
