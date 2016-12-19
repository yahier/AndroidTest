package algorithm;

/**
 * ռ��ǰ��ҵ���߼��� ���������������
 * 
 * @author IKKI
 * @2010-03-18
 * 
 */
public class Model {

	private int year, month, day;// �������
	// �Ա�//for males

	// ����
	private static final String yearString = "ZYXWOTZYQVUTSXWVNZYXPQTZRWVUMYXWOTZYQVUTSXWVNZYXPUTZRWVUMYXWOTZYQVUTSXWVNZYXPUTZRWVUMYXWOTZYQVUTSXWV";

	// ���Ե�ָ�����
	private static final String male_indexString = "VTWZXYURPSOMNQYWZVTUXOMPSQRNWUXTYZVMRNQOPSUZVYWXTRPSOMNQTYUXVWZPNQMRSOYWZVTUXNSORPQM";
	private static final String male_profString = "CDBADCABBACD";

	private static final String females_indexString = "OMPSQRNYWZVTUXSQMPNORUZVYWXTQORNSMPZXTWUVYOMPSQRNXVYUZTWNSORPQMVTWZXYUSQMPNORTYUXVWZ";
	private static final String females_profString = "ACDBCABDDBCA";

	private char ys, p1;
	private int i, p2;

	private String mString = null;

	private int sex;
	private char ys1;

	private String yearLen = "";
	private int place = 0;
	private String profession;
	private String charString = null;
	private String strLesson = null;

	private static final String SIGN = ",";

	/**
	 * ���캯��
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public Model(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;

		init();

	}

	public Model() {
	}

	public String getData() {

		return place + SIGN + profession + SIGN + charString + SIGN + strLesson;

	}

	/**
	 * ���� ���곤 ����ֵ����
	 * 
	 * @return
	 */
	public String getYearLen() {
		return yearLen;
	}

	private void init() {

		ys = yearString.charAt(year);

		int isSex = this.getSex();
		if (isSex == 1) {// ȡ����
			place = this.getMalePlace();// ��ȡ����if (place == 1)
										// countryString="���9�-˹���ޣ�Alaska��";
		} else {
			place = this.getFemalesPlace();// ��ȡ����
		}

		// profession ��ȡרҵ��� ����ֵ if (pro == "A1") var proString =
		// "���}�,���";
		if ((p1 != 'A' || p1 != 'B' || p1 != 'C' || p1 != 'D')
				&& (p2 != 1 || p2 != 2 || p2 != 3 || p2 != 4 || p2 != 5
						|| p2 != 6 || p2 != 7)) {

			profession = Character.toString(p1) + p2;
		} else {
			profession = "A0";
		}

		if (ys == 'M')
			mString = "185014001125102507000700180014751800130011751100";

		else if (ys == 'N')
			mString = "092518750425185017501350080006750825182515250875";

		else if (ys == 'O')
			mString = "172516750875070013251825177508001075165009001625";

		else if (ys == 'P')
			mString = "145005001800100008000550165017001325072511001550";

		else if (ys == 'Q')
			mString = "100014500950042517001525135011001625122517251025";

		else if (ys == 'R')
			mString = "097513751200127504500825137513500700092509250725";

		else if (ys == 'S')
			mString = "122506251250142509251150147507501300157506001125";

		else if (ys == 'T')
			mString = "117514001825127517500975185011501600187515251850";

		else if (ys == 'U')
			mString = "090009000775105013751675107515000825072510251500";

		else if (ys == 'V')
			mString = "122507501825140011501325167512751475160009501200";

		else if (ys == 'W')
			mString = "057516750775047517001450085017251775102517750400";

		else if (ys == 'X')
			mString = "180015751425157515501200160012001300037507751250";

		else if (ys == 'Y')
			mString = "107512501000165009501825155014250800175010750875";

		else
			mString = "097505251175085015751125177513500700065013501050";

		ys1 = mString.charAt((month - 1) * 4);
		yearLen = String.valueOf(ys1);
		if (ys1 == '0') {

			yearLen = "";
		}

		yearLen = yearLen + String.valueOf(mString.charAt((month - 1) * 4 + 1));
		yearLen = yearLen + String.valueOf(mString.charAt((month - 1) * 4 + 2));
		yearLen = yearLen + String.valueOf(mString.charAt((month - 1) * 4 + 3));

		// ///////////////////////characteristics ����/////////////////////////

		// ��ݿ��Ӧ��ţ��ۣ�1��7����0��1����

		if (place - 2 * (place / 2) > 0) {

			charString = "C" + p2 + "1";

		} else {
			charString = "C" + p2 + "0";
		}

		if (day < 12)
			strLesson = "L" + p2 + "0";
		else if (day < 22)
			strLesson = "L" + p2 + "1";
		else
			strLesson = "L" + p2 + "2";
	}

	/**
	 * �Ա��߼� return ���� 1 Ϊ���� ���� ΪŮ��
	 */
	public int getSex() {

		if (month - 2 * (month / 2) == 0) {
			if (year - 4 * (year / 4) == 0)
				sex = 1;
			else
				sex = 2;
		} else if (year - 4 * (year / 4) == 0)
			sex = 0;
		else
			sex = 1;

		return sex;
	}

	private int getMalePlace() {

		p1 = male_profString.charAt(month - 1);

		for (i = 0; i <= 6; i++) {

			if (ys == male_indexString.charAt((month - 1) * 7 + i))
				break;
		}

		p2 = i + 1;

		// PLACE OF BIRTH Male

		if (p2 == 1) {

			if (day < 3)
				place = 5;

			else if (day < 10)
				place = 46;

			else if (day < 17)
				place = 37;

			else if (day < 24)
				place = 48;

			else if (day < 31)
				place = 65;

			else
				place = 6;
		}

		if (p2 == 2) {

			if (day < 8)
				place = 28;

			else if (day < 15)
				place = 58;

			else if (day < 22)
				place = 10;

			else if (day < 29)
				place = 38;

			else
				place = 11;
		}

		if (p2 == 3) {

			if (day < 4)
				place = 29;

			else if (day < 11)
				place = 53;

			else if (day < 18)
				place = 30;

			else if (day < 25)
				place = 69;

			else
				place = 1;
		}

		if (p2 == 4) {

			if (day < 7)
				place = 74;

			else if (day < 14)
				place = 4;

			else if (day < 21)
				place = 47;

			else if (day < 28)
				place = 20;

			else
				place = 26;
		}

		if (p2 == 5) {

			if (day < 5)
				place = 23;

			else if (day < 12)
				place = 21;

			else if (day < 19)
				place = 44;

			else if (day < 26)
				place = 16;

			else
				place = 43;
		}

		if (p2 == 6) {

			if (day < 6)
				place = 34;

			else if (day < 13)
				place = 27;

			else if (day < 20)
				place = 14;

			else if (day < 27)
				place = 41;

			else
				place = 50;
		}

		if (p2 == 7) {
			if (day < 2)
				place = 73;
			else if (day < 9)
				place = 63;
			else if (day < 16)
				place = 66;
			else if (day < 23)
				place = 54;
			else if (day < 30)
				place = 61;
			else
				place = 72;
		}

		return place;
	}

	/**
	 * ���� ���Ϊ Ů�Ե����� ����
	 * 
	 * @return ����
	 */
	private int getFemalesPlace() {

		p1 = females_profString.charAt(month - 1);

		for (i = 0; i <= 6; i++) {

			if (ys == females_indexString.charAt((month - 1) * 7 + i))
				break;
		}

		p2 = i + 1;// ���� 7>=P2>0

		// PLACE OF BIRTH Female
		if (p2 == 1) {
			if (day < 3)
				place = 22;
			else if (day < 10)
				place = 17;
			else if (day < 17)
				place = 36;
			else if (day < 24)
				place = 59;
			else if (day < 31)
				place = 51;
			else
				place = 9;
		}
		if (p2 == 2) {

			if (day < 8)
				place = 40;

			else if (day < 15)
				place = 2;

			else if (day < 22)
				place = 64;

			else if (day < 29)
				place = 56;

			else
				place = 35;
		}

		if (p2 == 3) {

			if (day < 4)
				place = 19;

			else if (day < 11)
				place = 67;

			else if (day < 18)
				place = 13;

			else if (day < 25)
				place = 32;

			else
				place = 31;
		}
		if (p2 == 4) {

			if (day < 7)
				place = 15;

			else if (day < 14)
				place = 49;

			else if (day < 21)
				place = 12;

			else if (day < 28)
				place = 39;

			else
				place = 33;
		}

		if (p2 == 5) {
			if (day < 5)
				place = 42;
			else if (day < 12)
				place = 60;
			else if (day < 19)
				place = 24;
			else if (day < 26)
				place = 3;
			else
				place = 52;
		}

		if (p2 == 6) {
			if (day < 6)
				place = 18;
			else if (day < 13)
				place = 25;
			else if (day < 20)
				place = 57;
			else if (day < 27)
				place = 45;
			else
				place = 62;
		}
		if (p2 == 7) {
			if (day < 2)
				place = 8;
			else if (day < 9)
				place = 55;
			else if (day < 16)
				place = 70;
			else if (day < 23)
				place = 68;
			else if (day < 30)
				place = 71;
			else
				place = 7;
		}
		return place;
	}
}
