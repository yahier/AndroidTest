package date;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class OnDate {
    public static void main(String[] args) {

        //testParse();
        //testDataConvert();
        //convertStr();
        compareStr();
    }

    void dayOff() {
        Calendar cl = Calendar.getInstance();
        cl.set(1900, 0, 31); // 1900-01-31��ũ��1900�����³�һ �ո��� ��
        Date baseDate = cl.getTime();
        int offset = (int) (baseDate.getTime()) / 86400000; // ����(86400000=24*60*60*1000)
        System.out.println(" baseDate.getTime() is  " + baseDate.getTime());
        System.out.println("Lauar..offset..." + offset);
    }

    void getCurrentTime() {
        String time = new Date().toLocaleString();
        System.out.println("time is " + time.substring(0, time.length() - 3));
    }


    @SuppressWarnings("deprecation")
    static void testParse() {
        String str = "1989-12-15";
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Date date = format.parse(str);
            System.out.println(date.getDate());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    static void testDataConvert() {
        long l1 = 11132 >> 5;
        long l2 = -3 >>> 1;

        float f = l1;
        System.out.println("testDataConvert l1:" + l1 + "  l2:" + l2 + "  f:" + f);

    }

    static void convertStr() {
        System.out.println("convertStr:" + 1 + 2 + "455" + 4);//124554
        System.out.println(1 + 2 + "455" + 4);//34554

        String s;
        //System.out.println(s);//编辑错误

        int a = 0b11; //3
        int b = 011; //9
        int c = 0x11; //17

        System.out.println("a:" + a + " b" + b + " c:" + c);

    }


    static void compareStr() {
        String s1 = "a";
        String s2 = "a";
        String s3 = new String("a");
        boolean isEqual = s1 == s2;
        boolean isEqual2 = s1 == s3;
        System.out.println("eq1:" + s1 == s2);//false 最后比较的是 eq1a == a
        System.out.println("eq1:" + (s1 == s2));//true
        System.out.println("eq1:" + isEqual);//true
        System.out.println("eq2:" + isEqual2);//false
    }

    static void testIO() throws IOException {
        FileReader reader = new FileReader("");
        FileWriter writer = new FileWriter("");

        BufferedReader bufferedReader = new BufferedReader(reader);
        bufferedReader.readLine();

        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("");
        bufferedWriter.newLine();

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1").append("2");
        stringBuffer.toString();

        //int a[4][6] = new int[4][6];
        int b[] = {1,2,3,4};
    }

    static void testVector(){
        Vector<Object> vector = new Vector<>();
        vector.add(1);
        vector.add("2");
    }
}
