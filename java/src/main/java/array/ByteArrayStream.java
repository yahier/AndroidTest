package array;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * 如何将byte[]转换称String,内容不变呢。使用 ISO-8859-1 编码
 * 由于 UTF-8 是多字节编码，需要用多个字节来表示一个字符的编码，所以也就出现了在转换之后 byte[] 数组长度、内容不一致的情况。
 * <p>
 * 而 ISO-8859-1 编码是单字节编码，所以使用该编码就不会出现上面的问题
 */
public class ByteArrayStream {
    static byte[] data = {66, 77, -50, 33, 40, 37, 34, 41, 38, 31, 38, 35, 28, 35,
            34, 60, 69, 68, 95, 103, 104, 111, 119, 120, -128, -121, -118,
            -124, -117, -114, -119, -112, -107, -121, -114, -109, -123,
            -117};


    public static void main(String[] args) {
        String charset = Charset.defaultCharset().name();//UTF-8
        System.out.println("charset:" + charset);
        test();
    }

    /**
     * 将byte[]转成string，再专程byte[] ，怎么变化了呢
     */
    static void test() {
        String t = null;
        {
            t = new String(data);
            byte[] c = t.getBytes();
            System.out.println("c:" + Arrays.toString(c));//内容和原data数组不同
        }

        {
            try {
                t = new String(data, "ISO-8859-1");
                byte[] c = t.getBytes("ISO-8859-1");
                System.out.println("c:" + Arrays.toString(c));//内容和原data数据相同
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }


    }

    static void test2() {
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
