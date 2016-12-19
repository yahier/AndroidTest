package string;

public class Replace {
	public static void main(String[] args) {
		changedFormatOfThime("农历2018年六月二十五");
	}
	
	static String changedFormatOfThime(String nianyue) {
		String nian = "年", yue = "月", ri = "日";
		int indexNian = nianyue.indexOf(nian);
		int indexYue = nianyue.indexOf(yue);
		int indexRi = nianyue.indexOf(ri);
		nianyue=nianyue.replace('日','-');
		nianyue=nianyue.replace('月','-');
		nianyue = nianyue.replace('年', '-');
		System.out.println(nianyue);
		return nianyue;
	}

}
