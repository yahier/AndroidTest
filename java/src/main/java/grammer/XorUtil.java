package grammer;

/**
 * Created by yahier on 2018/8/1.
 */

public class XorUtil {

    public static int xorProtocol(byte[] buffer) {
        int init = 0x00;
        for (byte tmp : buffer) {
            init = init ^ tmp;
        }
        return init;
    }


    public static int getCrc16(byte[] data) {
        int high;
        int flag;

        // 16位寄存器，所有数位均为1
        int wcrc = 0xffff;
        for (int i = 0; i < data.length; i++) {
            // 16 位寄存器的高位字节
            high = wcrc >> 8;
            // 取被校验串的一个字节与 16 位寄存器的高位字节进行“异或”运算
            wcrc = high ^ data[i];

            for (int j = 0; j < 8; j++) {
                flag = wcrc & 0x0001;
                // 把这个 16 寄存器向右移一位
                wcrc = wcrc >> 1;
                // 若向右(标记位)移出的数位是 1,则生成多项式 1010 0000 0000 0001 和这个寄存器进行“异或”运算
                if (flag == 1)
                    wcrc ^= 0xa001;
            }
        }

        return wcrc;
    }

    /**
     * 将10进制转成16进制
     */
    public static void calculateToOX(int data) {
        StringBuffer str = new StringBuffer();
        while (data > 16) {
            int a1 = data / 16;
            str.append(Integer.toHexString(a1));

            data = data - a1 * 16;
        }
        System.out.println(str);

    }

    public static int xorProtocolV2(byte[] buffer) {
        int init = 0x00;
        for (int i = 2; i < buffer.length - 1; i++) {
            byte tmp = buffer[i];
            init = init ^ tmp;
        }
        return init;
    }

    public static int xorProtocolUpdate(int init, byte[] buffer, int len) {
        for (int i = 0; i < len; i++) {
            byte tmp = buffer[i];
            init = init ^ tmp;
        }
        return init;
    }

}