package regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mypattern {
	static Pattern p = Pattern.compile("[a-z]|[A-Z]");
	//String as = "sddv.<>.ddf�ҡ����ԡ���";

	public static void main(String[] args) {
		split("yay�����ҵ�yayayayYAYA");// [,,�����ҵ�]
		//regxChinese();
	}

	static void split(String str) {
		String[] strs = p.split(str);
		System.out.println("����  ��   "+strs.length);
		System.out.println(Arrays.toString(strs));
		
		System.out.println(strs[0]);
		System.out.println(strs[1]);
		System.out.println(strs[2]);
		/*String a="1,2,3,4,5";
		String b="2,";
		String[] datas = a.split(b);
		System.out.println("datas length is "+datas.length);
		System.out.println(datas[0]);
		System.out.println(datas[1]);
		System.out.println(Arrays.toString(datas));*/
	}

	public static void regxChinese() {
		//Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
		String s = "TITLE��������" ;    //����s = TITLE��������
	      Pattern p = Pattern.compile("(?<=TITLE)([\u4e00-\u9fa5] )");       
	       Matcher m = p.matcher(s);    
	      while(m.find()){    //�ж��Ƿ�ƥ��     
	    	  System.out.println("2344");
	           System.out.println(m.group());    //ƥ��ɹ�������������ַ�     
	       } 
	}
}