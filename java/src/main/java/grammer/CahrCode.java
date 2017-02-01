package grammer;

import java.io.PrintStream;

public class CahrCode {
    public static void main(String[] args) {
        //teUnicode();
        //ssstestSystem();
        test();
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
