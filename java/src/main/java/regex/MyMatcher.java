package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MyMatcher {
    public static void main(String[] args) {
        //tongji();
        boolean result = isFitZipCodeOfUSA("1237A-8as-");
        System.out.println("result:" + result);
        boolean result2 = isNumberic2("-864432000000");
        System.out.println("result2:" + result2);

        boolean result3 = isFormatOfyyyyMMdd("2017-08-11");
        System.out.println("result3:" + result3);
        isPhone();
    }


    // 字符里是全为数字 负数也算
    public static boolean isNumberic2(String str) {
        return str.matches("[-]?[\\d]*");
    }

    public static void isPhone() {
        String phone = "+8618520137573";
        //前面是0-1个+，后面是11到13个数字
        boolean isMatched = phone.matches("[+]{0,1}\\d{11,13}");
        System.out.println("isPhone isMatched is " + isMatched);
    }


    public static boolean isFormatOfyyyyMMdd(String str) {
        return str.matches("[\\d]{4}[-][\\d]{1,2}[-][\\d]{1,2}");
    }

    public static boolean isFitZipCodeOfUSA(String postCode) {
        if (postCode.length() > 10)
            return false;
        Pattern pattern = Pattern.compile("[\\d|a-z|A-Z|-]*");
        Matcher matcher = pattern.matcher(postCode);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    static void tongji() {
        String content = "���Ƕ���ab�ҾԵ�BEYOND,f4��what .520";
        Pattern ch = Pattern.compile("[\u4e00-\u9fa5]");//ͳ������
        //Pattern en = Pattern.compile("[a-zA-Z]");//ͳ�ƴ�Сд
        //Pattern no = Pattern.compile("[\\d]");//ͳ������
        Matcher m = ch.matcher(content);
        int count = 0;
        while (m.find()) {
            count++;
        }
        System.out.println(count);

    }

    /**
     * ��֤�ʼ���ַ
     */
    static void isEmail() {
        String regex = "\\w{1,}@\\w{1,}\56\\w{1,}";
        String str1 = "yahier@sina.com";
        if (str1.matches(regex)) {
            System.out.println(str1 + "��һ��Email��ַ");
        }
    }

    static boolean isAllMatch(String str) {
        Pattern p = Pattern.compile("[^\u4e00-\u9fa5]*");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        System.out.println(b);
        return b;
    }

    /**
     * ����ƥ�� �ͷ���true
     *
     * @param str
     * @return
     */
    static boolean IsPartMatch(String str) {
        Pattern p = Pattern.compile("[a-z]");
        Matcher m = p.matcher(str);
        System.out.println("����������    " + m.replaceAll("..."));
        // ƥ��������λ�� str�����κ��ֶ���������������true

        boolean b = m.find();
        System.out.println("isMatch..." + b);
        System.out.println(m.group() + "   " + m.groupCount());
        return b;
    }

    static void go() {
        String con = "a1b2";
        Pattern p = Pattern.compile("[\\d]");
        Matcher m = p.matcher(con);
        System.out.println(m.replaceFirst("...."));

    }

    /**
     * ƥ���׸��ַ�
     *
     * @param str
     * @return
     */
    static boolean IsFirstMatch(String str) {
        Pattern p = Pattern.compile("[a-z]");
        Matcher m = p.matcher(str);
        // ƥ��str��ǰ���һλ��
        boolean b = m.lookingAt();
        System.out.println("b is " + b);
        return b;
    }

    /**
     * �˷������� ��ʱ�����õ�
     *
     * @param str
     */
    static void findToReplace(String str) {
        Pattern p = Pattern.compile("[a-z]+");
        Matcher m = p.matcher(str);
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (m.find()) {
            m.appendReplacement(sb, str);
            System.out.println(i);
            i++;
        }
        // �ӽ�ȡ�� ��������ַ�����
        m.appendTail(sb);
        String s = sb.toString();
        System.out.println(s);

    }
}
