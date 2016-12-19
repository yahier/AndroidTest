package string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Parse {
	public static void main(String[] args) {
/*		Parse parse = new Parse();
		String content = "a\bc|def|rt";
		String content2 = "windows" + "ios" + "android";
		parse.p1(content);*/
		//p2();
		//p3();
		//test3();
		test4();
	}

	
	void p1(String s) {
		String[] a = s.split("\b");
		String[] b = s.split("\\|");
		System.out.println(a.length);
		System.out.println(b.length);
	}

	
	static void p2() {

		String str = "2012/03/23";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			System.out.println(sdf.parse(str));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	
	static void p3(){
		 
        String dStr = "2001-12-12";  
        Date d = null;  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        try {  
            d = (Date) sdf.parse(dStr);  
        } catch (ParseException pe) {  
            System.out.println(pe.getMessage());  
        }  
        System.out.println(d);  
      
	}
	
	static void test3(){
		String a = "1,3";
		String[] array = a.split(",");
		System.out.println(Arrays.toString(array));
	}

	
	static void test4(){
		String[] phone = {"18520137571","18520137575","18520137579","18520137570"};
		System.out.println(Arrays.toString(phone));
	}
}
