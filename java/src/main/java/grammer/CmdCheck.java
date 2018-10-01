package grammer;

import string.StringUtil;

/**
 * Created by yahier on 2018/8/1.
 * 计算末尾预留位
 */

public class CmdCheck {

    /**
     * 预留位的计算规则是 (从Address开始 异或运算)
     * 我的计算结果是 AA 66 00 51 00 01 00 00 30 C0
     * 下位机结果是  AA 66 00 51 00 01 00 00 AC 17
     */
    private static void test(byte[] buffer) {
        System.out.println(StringUtil.formatBytes(buffer));

        int bufferHeaderLength = 2;
        int bufferTmpLength = buffer.length - bufferHeaderLength;
        byte[] bufferTmp = new byte[bufferTmpLength];
        System.arraycopy(buffer, bufferHeaderLength, bufferTmp, 0, bufferTmpLength);
//        {
//            int xor = XorUtil.xorProtocol(bufferTmp);
//            buffer[buffer.length - 1] = (byte) xor;
//
//            System.out.println(Arrays.toString(buffer));
//        }

        {
            String value = XorUtil.calculateCrc16(buffer);
            System.out.println("value:" + value);
            int a1, a2;
            int valueLength = value.length();
            if (valueLength > 2) {
                a1 = Integer.parseInt(value.substring(0, valueLength - 2), 16);
                a2 = Integer.parseInt(value.substring(valueLength - 2, valueLength), 16);
            } else {
                a1 = 0;
                a2 = Integer.parseInt(value, 16);
            }
            System.out.println("xor:" + value + " " + value + "   " + a1 + ":" + a2);
            buffer[buffer.length - 2] = (byte) a1;
            buffer[buffer.length - 1] = (byte) a2;

            System.out.println(StringUtil.formatBytes(buffer));
        }
//
//        {
//            int xor = XorUtil.getCrc16(bufferTmp);//10560 29 40
//            String value = Integer.toHexString(xor);
//            int a1, a2;
//            int valueLength = value.length();
//            if (valueLength > 2) {
//                a1 = Integer.parseInt(value.substring(0, valueLength - 2), 16);
//                a2 = Integer.parseInt(value.substring(valueLength - 2, valueLength), 16);
//            } else {
//                a1 = 0;
//                a2 = Integer.parseInt(value, 16);
//            }
//            System.out.println("xor:" + xor + " " + value + "   " + a1 + ":" + a2);
//            buffer[buffer.length - 2] = (byte) a1;
//            buffer[buffer.length - 1] = (byte) a2;
//
//            System.out.println(StringUtil.formatBytes(buffer));
//        }

    }

    /**
     * 字符串转成 16 进制数字
     */
    private static void dataConvert() {
        int a = 0X34a6;
        String value = "a6";
        int a2 = Integer.parseInt("62", 16);
        System.out.println("a2:" + a2);

    }

    public static void test2() {
        int ax = 0x50;
        System.out.println("ax:" + ax);
    }


    public static void testBinary(int index) {
        String value = "1";
        for (int i = 0; i < index - 1; i++) {
            value = value + "0";
        }

        System.out.println("value:" + value);
        int a = Integer.parseInt(value, 2);
        System.out.println("a:" + a);
    }

    private static void test1(int... a) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            if (temp < 1) break;
            result = result | 1 << (temp - 1);
        }
        //String resultStr = String.valueOf(result);
        String result2 = Integer.toBinaryString(result);
        System.out.println("value1:" + result2);
        int value = Integer.parseInt(result2, 2);
        System.out.println("value2:" + value);
    }

    /**
     * 将参数转换成1000格式的数（手机回收开箱子使用）
     * return 参数为2 返回10;参数为24 则返回1010
     */
    public static void test(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int value = data[i];

        }

    }

    public static void main(String[] args) {
        byte[] data = {(byte) 0XAA, 0X66, 0X00, 0X51, 0X00, 0X01, 0X00, 0X00};
        //AA 66 00 51 00 01 00 00 30 C0
        //test(data);
        //test2();
        //dataConvert();
        //testBinary(10);
       // testBinary(6);
        test1(11, 12);
    }
}
