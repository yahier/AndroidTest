package grammer;

import java.io.PrintStream;

public class CahrCode {
    public static void main(String[] args) {
        //teUnicode();
        //ssstestSystem();
        //test();
        test2();
    }

    static void teUnicode() {
        String s = "中国";
        for (int i = 0; i < s.length(); i++) {
            int a = (int) s.charAt(i);//

            String str = Integer.toBinaryString(a);//binary
            String hex = Integer.toHexString(a);//这是Unicode？
            System.out.println(a + "  " + str + "  " + hex);
        }
        System.out.println();
        byte[] data = null;
        data = s.getBytes();
        for (int i = 0; i < data.length; i++) {
            System.out.print(Integer.toHexString(data[i]) + "  ");
            System.out.println(data[i]);
        }

        for (int i = 0; i < data.length; i++) {
            //System.out.print(Integer.toHexString(data[i])+"  ");
            System.out.write(data[i]);

        }
        System.out.println();
        System.out.println(data.length);
    }

    static void testSystem() {
        System.getProperties().list(System.out);
    }


    static void test2() {
        char char1 = '丨';
        char char2 = 'b';
        char char3 = 'a';
        int char4 = char2 + char3;//果然等于 97+98的值
        String hex1 = Integer.toHexString(char1);
        System.out.println("test:" + char1 + "," + hex1);
    }

    /**
     * PrintStream的write()方法 意义何在
     */
    static void test() {
        PrintStream p = System.out;
        p.write(12);
        p.flush();
        System.out.println(13);
    }
}
