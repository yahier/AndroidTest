package array;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 如何将byte[]转换称String,内容不变呢。
 */
public class ByteArrayStream {
    public static void main(String[] args) {
        test();
    }

    static void test() {
        byte[] data = {66, 77, -50, 33, 40, 37, 34, 41, 38, 31, 38, 35, 28, 35,
                34, 60, 69, 68, 95, 103, 104, 111, 119, 120, -128, -121, -118,
                -124, -117, -114, -119, -112, -107, -121, -114, -109, -123,
                -117};

        String t = new String(data);
        System.out.println("t:" + t);
        byte[] c = t.getBytes();
        System.out.println("c:" + Arrays.toString(c));
    }

    static void s(byte[] data) {
        ByteArrayInputStream out = new ByteArrayInputStream(data);
        String con = out.toString();
        System.out.println(con);
        back(con);
    }

    static void back(String s) {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bout);
        try {
            dos.writeUTF(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] buf = bout.toByteArray();// 获取内存缓冲区中的数据
        Arrays.toString(buf);

    }

}
