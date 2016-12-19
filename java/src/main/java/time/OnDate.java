package time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OnDate {
	public static void main(String[] args) {

		testParse();
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
		System.out.println("time is "+time.substring(0, time.length()-3));
	}
	
	
	@SuppressWarnings("deprecation")
	static void testParse(){
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
}
