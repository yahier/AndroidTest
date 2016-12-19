package string;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

//import com.veriweb.util.OurLog;
public final class Lauar {

	private static int monCyl, dayCyl, yearCyl;

	private static int year, month, day;

	private static boolean isLeap;
	static String[] tiangans = { "��", "��", "��", "��", "��", "��", "��", "��", "��",
			"��" };
	static int[][] yinyangs = { { 0, 0, 1 }, { 0, 1, 0 }, { 0, 1, 1 },
			{ 1, 1, 0 }, { 1, 1, 1 }, { 0, 0, 0 }, { 1, 0, 1 }, { 1, 0, 0 } };
	private static int[] lunarInfo = { 0x04bd8, 0x04ae0, 0x0a570, 0x054d5,
			0x0d260, 0x0d950, 0x16554, 0x056a0, 0x09ad0, 0x055d2, 0x04ae0,
			0x0a5b6, 0x0a4d0, 0x0d250, 0x1d255, 0x0b540, 0x0d6a0, 0x0ada2,
			0x095b0, 0x14977, 0x04970, 0x0a4b0, 0x0b4b5, 0x06a50, 0x06d40,
			0x1ab54, 0x02b60, 0x09570, 0x052f2, 0x04970, 0x06566, 0x0d4a0,
			0x0ea50, 0x06e95, 0x05ad0, 0x02b60, 0x186e3, 0x092e0, 0x1c8d7,
			0x0c950, 0x0d4a0, 0x1d8a6, 0x0b550, 0x056a0, 0x1a5b4, 0x025d0,
			0x092d0, 0x0d2b2, 0x0a950, 0x0b557, 0x06ca0, 0x0b550, 0x15355,
			0x04da0, 0x0a5d0, 0x14573, 0x052d0, 0x0a9a8, 0x0e950, 0x06aa0,
			0x0aea6, 0x0ab50, 0x04b60, 0x0aae4, 0x0a570, 0x05260, 0x0f263,
			0x0d950, 0x05b57, 0x056a0, 0x096d0, 0x04dd5, 0x04ad0, 0x0a4d0,
			0x0d4d4, 0x0d250, 0x0d558, 0x0b540, 0x0b5a0, 0x195a6, 0x095b0,
			0x049b0, 0x0a974, 0x0a4b0, 0x0b27a, 0x06a50, 0x06d40, 0x0af46,
			0x0ab60, 0x09570, 0x04af5, 0x04970, 0x064b0, 0x074a3, 0x0ea50,
			0x06b58, 0x055c0, 0x0ab60, 0x096d5, 0x092e0, 0x0c960, 0x0d954,
			0x0d4a0, 0x0da50, 0x07552, 0x056a0, 0x0abb7, 0x025d0, 0x092d0,
			0x0cab5, 0x0a950, 0x0b4a0, 0x0baa4, 0x0ad50, 0x055d9, 0x04ba0,
			0x0a5b0, 0x15176, 0x052b0, 0x0a930, 0x07954, 0x06aa0, 0x0ad50,
			0x05b52, 0x04b60, 0x0a6e6, 0x0a4e0, 0x0d260, 0x0ea65, 0x0d530,
			0x05aa0, 0x076a3, 0x096d0, 0x04bd7, 0x04ad0, 0x0a4d0, 0x1d0b6,
			0x0d250, 0x0d520, 0x0dd45, 0x0b5a0, 0x056d0, 0x055b2, 0x049b0,
			0x0a577, 0x0a4b0, 0x0aa50, 0x1b255, 0x06d20, 0x0ada0 };

	private static int[] solarMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,
			30, 31 };

	private static String[] Gan = { "��", "��", "��", "��", "��", "��", "��", "��",
			"��", "��" };

	private static String[] Zhi = { "��", "��", "��", "î", "��", "��", "��", "δ",
			"��", "��", "��", "��" };

	private static String[] Animals = { "��", "ţ", "��", "��", "��", "��", "��", "��",
			"��", "��", "��", "��" };

	private static int[] sTermInfo = { 0, 21208, 42467, 63836, 85337, 107014,
			128867, 150921, 173149, 195551, 218072, 240693, 263343, 285989,
			308563, 331033, 353350, 375494, 397447, 419210, 440795, 462224,
			483532, 504758 };

	private static String[] nStr1 = { "��", "һ", "��", "��", "��", "��", "��", "��",
			"��", "��", "ʮ" };

	private static String[] nStr2 = { "��", "ʮ", "إ", "ئ", "��" };

	private static String[] monthNong = { "��", "��", "��", "��", "��", "��", "��",
			"��", "��", "��", "ʮ", "ʮһ", "ʮ��" };

	private static String[] yearName = { "��", "Ҽ", "��", "��", "��", "��", "½",
			"��", "��", "��" };

	public Lauar() {
	}

	// ====================================== ����ũ�� y���������
	private static int lYearDays(int y) {
		int i;
		int sum = 348; // 29*12
		for (i = 0x8000; i > 0x8; i >>= 1) {
			// OurLog.debug("i="+i);
			sum += (lunarInfo[y - 1900] & i) == 0 ? 0 : 1; // ����+1��
		}
		return (sum + leapDays(y)); // +���µ�����
	}

	// ====================================== ����ũ�� y�����µ�����
	private static int leapDays(int y) {
		if (leapMonth(y) != 0)
			return ((lunarInfo[y - 1900] & 0x10000) == 0 ? 29 : 30);
		else
			return (0);
	}

	// ====================================== ����ũ�� y�����ĸ��� 1-12 , û�򴫻� 0
	private static int leapMonth(int y) {
		return (lunarInfo[y - 1900] & 0xf);
	}

	// ====================================== ����ũ�� y��m�µ�������
	private static int monthDays(int y, int m) {
		return ((lunarInfo[y - 1900] & (0x10000 >> m)) == 0 ? 29 : 30);
	}

	// ====================================== ���ũ��, �����������, ����ũ���������
	// ����������� .year .month .day .isLeap .yearCyl .dayCyl .monCyl
	private static void Lunar1(Date objDate) {
		int i, leap = 0, temp = 0;
		// int monCyl,dayCyl,yearCyl;
		// int year,month,day;
		// boolean isLeap;
		Calendar cl = Calendar.getInstance();
		cl.set(1900, 0, 31); // 1900-01-31��ũ��1900�����³�һ
		Date baseDate = cl.getTime();
		// 1900-01-31��ũ��1900�����³�һ
		int offset = (int) ((objDate.getTime() - baseDate.getTime()) / 86400000); // ����(86400000=24*60*60*1000)
		// System.out.println(offset);
		dayCyl = offset + 40; // 1899-12-21��ũ��1899�����¼�����
		monCyl = 14; // 1898-10-01��ũ��������
		// �õ�����
		for (i = 1900; i < 2050 && offset > 0; i++) {
			temp = lYearDays(i); // ũ��ÿ������
			offset -= temp;
			monCyl += 12;
		}
		if (offset < 0) {
			offset += temp;
			i--;
			monCyl -= 12;
		}
		year = i; // ũ�����
		yearCyl = i - 1864; // 1864���Ǽ�����
		leap = leapMonth(i); // ���ĸ���
		isLeap = false;
		for (i = 1; i < 13 && offset > 0; i++) {
			// ����
			if (leap > 0 && i == (leap + 1) && isLeap == false) {
				--i;
				isLeap = true;
				temp = leapDays(year);
			} else {
				temp = monthDays(year, i);
			}
			// �������
			if (isLeap == true && i == (leap + 1))
				isLeap = false;
			offset -= temp;
			if (isLeap == false)
				monCyl++;
		}
		if (offset == 0 && leap > 0 && i == leap + 1)
			if (isLeap) {
				isLeap = false;
			} else {
				isLeap = true;
				--i;
				--monCyl;
			}
		if (offset < 0) {
			offset += temp;
			--i;
			--monCyl;
		}
		month = i; // ũ���·�
		day = offset + 1; // ũ�����
		// System.out.println(day);
	}

	private static int getYear() {
		return (year);
	}

	private static int getMonth() {
		return (month);
	}

	private static int getDay() {
		return (day);
	}

	private static int getMonCyl() {
		return (monCyl);
	}

	private static int getYearCyl() {
		return (yearCyl);
	}

	private static int getDayCyl() {
		return (dayCyl);
	}

	private static boolean getIsLeap() {
		return (isLeap);
	}

	// ============================== ���� offset ���ظ�֧, 0=����
	private static String cyclical(int num) {
		return (Gan[num % 10] + Zhi[num % 12]);
	}

	// ====================== ��������
	private static String cDay(int d) {
		String s;
		switch (d) {
		case 10:
			s = "��ʮ";
			break;
		case 20:
			s = "��ʮ";
			break;
		case 30:
			s = "��ʮ";
			break;
		default:
			s = nStr2[(int) (d / 10)];// ȡ��
			s += nStr1[d % 10];// ȡ��
		}
		return (s);
	}

	private static String cYear(int y) {
		String s = " ";
		int d;
		while (y > 0) {
			d = y % 10;
			y = (y - d) / 10;
			s = yearName[d] + s;
		}
		return (s);
	}

	public static String getLunar(String year, String month, String day) {

		Date sDObj;
		String s;
		int SY, SM, SD;

		int sy;
		SY = Integer.parseInt(year);
		SM = Integer.parseInt(month);
		SD = Integer.parseInt(day);
		sy = (SY - 4) % 12;

		Calendar cl = Calendar.getInstance();
		cl.set(SY, SM - 1, SD);
		sDObj = cl.getTime();
		// com.veriweb.util.OurLog.debug("sDObj="+sDObj);

		// ����
		Lunar1(sDObj); // ũ��
		String nianfen = cYear(getYear());
		s = "ũ�� " + "��" + Animals[sy] + "��" + nianfen + "��" + " ";
		String yuefen = monthNong[getMonth()];
		s += (getIsLeap() ? "��" : "") + yuefen + "��"
				+ (monthDays(getYear(), getMonth()) == 29 ? "С" : "��");
		String rizi = cDay(getDay());
		s += rizi + " ";
		s += "  " + cyclical(getYearCyl()) + "��" + cyclical(getMonCyl()) + "��"
				+ cyclical(getDayCyl()) + "��";
		 System.out.println("Lauar.ת���õ���������     "+s);
		return s;

	}

	static String[] getTianGan(int[] date) {
		int sy = (date[0] - 4) % 12;
		Calendar cl = Calendar.getInstance();
		cl.set(date[0], date[1] - 1, date[2]);
		Date sDObj = cl.getTime();

		Lunar1(sDObj);
		String s = "  " + cyclical(getYearCyl()) + "��" + cyclical(getMonCyl())
				+ "��" + cyclical(getDayCyl()) + "��";
		String[] array = new String[] { cyclical(getYearCyl()),
				cyclical(getMonCyl()), cyclical(getDayCyl()) };
		return array;
	}

	/**
	 * �������ִ��
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// ���ӶԱ�
		// ũ�� �������������� �� ���´�إ�� �������δ��������
		 System.out.println(getLunar("2008", "10", "10"));
		//int[] date = new int[] { 2008,10,10 };

		//String[] tiangans = getTianGan(date);
		//int[] yinyang = test(tiangans[0].substring(0, 1), tiangans[1].substring(0, 1), tiangans[2].substring(0, 1));
		//System.out.println(compare(yinyangs, yinyang));

	}

	/**
	 * ����һά�����ڶ�ά�����ж�Ӧ��index
	 * 
	 * @param yinyang
	 * @param yin
	 * @return
	 */
	static int compare(int[][] yinyang, int[] yin) {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 3; j++) {
				if (yinyang[i][j] != yin[j]) {
					break;

				} else if (j == 2)
					return i;
			}
		}
		return -1;

	}

	/**
	 * ����������õ����
	 * 
	 * @param date
	 * @return
	 */
	static int excutor(int[] date) {
		String[] tiangans = getTianGan(date);
		int[] yinyang = test(tiangans[0].substring(0, 1), tiangans[1]
				.substring(0, 1), tiangans[2].substring(0, 1));
		int index = compare(yinyangs, yinyang);
		return index;
	}

	static int[] test(String year, String month, String day) {
		// Ϊ0������س Ϊ1������س
		System.out.println(year + "" + month + day);
		int Y = mySerach(tiangans, year) % 2;
		int M = mySerach(tiangans, month) % 2;
		int D = mySerach(tiangans, day) % 2;
		System.out.println("������   " + Y + "  " + M + "   " + D);
		return new int[] { Y, M, D };

	}

	static int mySerach(String[] a, String value) {
		for (int i = 0; i < a.length; i++) {
			if (a[i].equals(value))
				return i;
		}
		return -1;
	}

}
