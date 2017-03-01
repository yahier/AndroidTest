package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 测试将 用户输入的字符串 写入文件,然后读出来。
 */
public class File_IO {
    final static String filePath = ObjIO.filePath;

    public static void main(String args[]) {
        //write(filePath);
        read();
    }

    static void write(String path) {
        byte buffer[] = new byte[120];
        String con = "yahier is sogo";
        try {
            int b = System.in.read(buffer);//等待输入
            System.out.println("b is  " + b);
            FileOutputStream writerSream = new FileOutputStream(path);
            writerSream.write(buffer);//写入用户输入
            //writerSream.write(con.getBytes());//写入固定语
            writerSream.flush();
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }

    static void read() {
        try {
            java.io.FileInputStream in = new java.io.FileInputStream(filePath);
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(reader);
            byte[] data = new byte[90];
            char[] chars = new char[60];
            int readLength = 0;
            try {
                //用三个流 分别将文件的内容读出来.都测试通过啦。
                //第一个
//                readLength = in.read(data);
//                while (readLength != -1) {
//                    System.out.println("1:" + readLength + ":" + new String(data, 0, readLength));
//                    readLength = in.read(data, 0, readLength);
//                }

                //第二个
//                while (readLength != -1) {
//                    readLength = reader.read(chars, 0, chars.length);
//                    if (readLength != -1)
//                        System.out.println("2:" + new String(chars, 0, readLength));
//                }
                //第三个
                //bufferedReader.skip(1);

                String readCon = "";
                while (readCon != null) {
                    readCon = bufferedReader.readLine();
                    if (readCon != null)
                        System.out.println("3:" + readCon);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}