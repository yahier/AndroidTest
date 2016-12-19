package myutil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyTime {
	String str = "1381841205000";
	long t = 1381841205000l;
	public static void main(String[] args) {
		//new MyTime().s();
		//System.out.println(""+System.currentTimeMillis());
		new MyTime().t();
	}
	
	void s(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date pubDate = null;
		try {
			pubDate = simpleDateFormat.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 System.out.println(""+simpleDateFormat.format(pubDate));
	}
	
	//

	
	void a(){
		Date date = new Date(t);
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//识别其中的Y M D 等符号
		System.out.println("    "+sim.format(date));// 打印出 2013年 什么啊154天
	}

	//计算倒计时
	void t(){
		String str = "2013-10-30 00:00:00";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//Date now = new Date();
		Calendar calendar = Calendar.getInstance();// 获取实例
	//	DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//构造格式化模板
	    Date	now = calendar.getTime(); //获取Date对象
		
	   System.out.println("....."+now.getMinutes());
		
		Date deadDate = null;
		try {
			 deadDate = simpleDateFormat.parse(str);
			 
			 
			long diff = deadDate.getTime() - now.getTime() ;
			if(diff<0){
				return;
			}
			long day = diff / (24 * 60 * 60 * 1000);
			long hour = (diff / (60 * 60 * 1000) - day * 24);
			long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			long s = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);//second
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
		

		
		
		long diff = deadDate.getTime() - now.getTime() ;
		
		long day = diff / (24 * 60 * 60 * 1000);
		long hour = (diff / (60 * 60 * 1000) - day * 24);
		long min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);//second
		
		
		
		String strTime = "";
		if (day > 0) {
			strTime += day + "天";
			strTime += hour + "小时";
			strTime += min + "分";
			strTime += s+"秒";
		} else {
			if (hour > 0) {
				strTime += hour + "小时";
				strTime += min + "分";
				strTime += s+"秒";
			} else if (min > 0) {
				strTime += min + "分";
				strTime += s+"秒";
			}else if(s>0){
				strTime += s+"秒";
				System.out.println(23456);
			}
		}
		
		System.out.println("计算的时间是   "+strTime);
	}

	
	
}
