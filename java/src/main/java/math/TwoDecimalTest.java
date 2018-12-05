package math;

import java.math.BigDecimal;

/**
 * Created by yahier on 12/5/18.
 */

public class TwoDecimalTest {

    public static void main(String[] args) {

        //get2Decimal(saveTwoDecimal(0));
        //get2Decimal(saveTwoDecimal(1.1));
        get2Decimal(saveTwoDecimal(1.11));
        //get2Decimal(saveTwoDecimal(1.111));
        get2Decimal("3");
        get2Decimal("3.1");
        get2Decimal("3.22");
        get2Decimal("3.333");
        get2Decimal("3.4444");
    }

    /**
     * 保留两位小数(向上取整)
     * 适用于回收端
     */
    public static String saveTwoDecimal(double value) {
        Double num = 0.0;
        BigDecimal bd = null;
        try {
            bd = BigDecimal.valueOf(value);
            bd = bd.setScale(2, BigDecimal.ROUND_UP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bd != null) {
            num = bd.doubleValue();
        }
        String newNum = String.valueOf(num);
        System.out.println(String.format("old=%s|new=%s", value, newNum));
        return newNum;
    }

    /**
     * 转换成 带两位小数
     * 没有小数或者位数不够时，进行填充;过长，则截取
     */
    private static String get2Decimal(String source) {
        int indexPoint = source.indexOf(".");
        int length = source.length();
        if (indexPoint < 0) {
            source = source + ".00";
        } else if (indexPoint >= 0) {
            int addZeroSize = 3 - (length - indexPoint);
            if (addZeroSize >= 0) {
                for (int i = 0; i < addZeroSize; i++) {
                    source = source + "0";
                }
            } else {
                source = source.substring(0, indexPoint + 3);
            }

        }

        System.out.println("result:" + source);
        return source;

    }

}
