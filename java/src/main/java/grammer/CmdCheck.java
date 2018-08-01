package grammer;

import java.util.Arrays;

/**
 * Created by yahier on 2018/8/1.
 * 计算末尾预留位
 */

public class CmdCheck {

    /**
     * 预留位的计算规则是 (从Address开始 异或运算)
     */
    private static void test(byte[] buffer) {
        System.out.println(Arrays.toString(buffer));

        int bufferHeaderLength = 2;
        int bufferTmpLength = buffer.length - bufferHeaderLength;
        byte[] bufferTmp = new byte[bufferTmpLength];
        System.arraycopy(buffer, bufferHeaderLength, bufferTmp, 0, bufferTmpLength);
        {
            int xor = XorUtil.xorProtocol(bufferTmp);
            buffer[buffer.length - 1] = (byte) xor;

            System.out.println(Arrays.toString(buffer));
        }


        {
            int xor = XorUtil.getCrc16(bufferTmp);//10560 29 40
            String value = Integer.toHexString(xor);
            int a1, a2;
            int valueLength = value.length();
            if (valueLength > 2) {
                a1 = Integer.valueOf(value.substring(0, valueLength - 2));
                a2 = Integer.valueOf(value.substring(valueLength - 2, valueLength));
            } else {
                a1 = 0;
                a2 = Integer.valueOf(value);
            }

            System.out.println("xor:" + xor + " " + value + "   " + a1 + ":" + a2);
            buffer[buffer.length - 2] = (byte) a1;
            buffer[buffer.length - 1] = (byte) a2;

            System.out.println(Arrays.toString(buffer));
        }

        {
            int xor = XorUtil.getCrc16(bufferTmp);//10560 29 40
            String value = Integer.toHexString(xor);

            int a1 = xor / 256;
            int a2 = xor % 256;
            System.out.println("xor:" + xor + " " + value + "   " + a1 + ":" + a2);
            buffer[buffer.length - 2] = (byte) a1;
            buffer[buffer.length - 1] = (byte) a2;

            System.out.println(Arrays.toString(buffer));
        }
    }


    public static void main(String[] args) {
        byte[] data = {(byte) 0XAA, 0X55, 0X1, 0X05, 0X56, 1, 1, 0, 2, 0, 0};
        test(data);
    }
}
