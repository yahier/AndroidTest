package string;

import java.util.Arrays;

public class TianGan {
	static String[] tiangans = { "甲", "乙", "丙", "丁", "戊", "已", "庚", " 辛", "壬",
			"癸" };
	static String tianGanOfYear;
	static String tianGanOfMonth;
	static String tianGanOfDay;

	public static void main(String[] args) {
		int[] a = { 2006, 4, 1 };
		tianGanOfYear = getYearTianGan(a[0]);
		tianGanOfMonth = getMonthTianGan(tianGanOfYear, a[1]);
		tianGanOfDay = getTianGanOfDay(a);
		System.out.println("分别是    " + tianGanOfYear + "    " + tianGanOfMonth
				+ "    " + tianGanOfDay);

	}

	/*
	 * 查体质的卦的类型*
	 */
	int combine(String tianganY, String tianganM, String tianganD) {
		int indexOfYear = Arrays.binarySearch(tiangans, tianganY);
		int indexOfMonth = Arrays.binarySearch(tiangans, tianganM);
		int indexOfDay = Arrays.binarySearch(tiangans, tianganD);
		// 0 2 4 6 8为阴爻 ，1 3 5 7 9是阳爻 然后组合把
		return -1;
	}

	static String getYearTianGan(int year) {
		return tiangans[(year + 6) % 10];

		/**
		 * 对应的 4 5 6... = 甲 乙 丙..
		 */

	}

	/**
	 * 获取月份纪年
	 * 说明：若遇甲或己的年份 ，正月是丙寅  为什么 或 ？两个年份明明不一样
	 * 
	 * @param tianganYear
	 * @param month
	 * @return
	 */
	static String getMonthTianGan(String tianganYear, int month) {
		int index = 0;
		if (tianganYear.equals(tiangans[0])
				|| (tianganYear.equals(tiangans[5]))) {
			index = 2;
		} else if (tianganYear.equals(tiangans[1])
				|| (tianganYear.equals(tiangans[6]))) {
			index = 4;
		} else if (tianganYear.equals(tiangans[2])
				|| (tianganYear.equals(tiangans[7]))) {
			index = 6;
		} else if (tianganYear.equals(tiangans[3])
				|| (tianganYear.equals(tiangans[8]))) {
			index = 8;
		} else if (tianganYear.equals(tiangans[4])
				|| (tianganYear.equals(tiangans[9]))) {
			index = 0;
		}
		// 计算与正月的月差  不确定是不是这样算 
		index += month - 1;
		index = index % 12;
		return tiangans[index];
	}

	// 如date是2003年4月1日
	static String getTianGanOfDay(int[] date) {
		int qian = date[0] / 100;// 世纪数-1
		int hou = date[0] % 100;// 年份后两位
		int sum = 4 * qian + qian / 4 + 5 * hou + hou / 4;
		sum += 3 * (date[1] + 1) / 5 + date[2] - 3 - 1;
		// 特别另外-1 因为下标有0 但数数是从1开始的
		return tiangans[sum % 10];

	}
}
