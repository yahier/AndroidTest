package algorithm.string;

/**
 * 字符串工具类
 */
public class StringUtils {
    static String str = "13246587"; //324
    static String strOrder = "123456789";


    static String temp = "";

    /**
     * 排列所有组合
     */
    static void placeAllCombination(String str, int startIndex) {
        String[] data = str.substring(startIndex).split("");
        for (int i = 0; i < str.length(); i++) {

            //子循环
            int times = data.length;
            for (int j = 0; j < times; j++) {
                String cur = data[i];
                System.out.println(data[i]);
                String newStr = str.replace(cur, "");
                placeAllCombination(newStr, 0);
            }
        }
    }

    /**
     * 判断大str里面有没有包含小str
     * 测试成功 写的太麻烦了.
     *
     * @deprecated instead of isContainedNew
     */
    static void isContained(String strBig, String str) {
        boolean result = true;
        char[] dataBig = strBig.toCharArray();
        char[] data = str.toCharArray();
        for (int i = 0; i < dataBig.length; i++) {
            result = false;
            //第一位满足
            int tempIndex = i;
            if (dataBig[i] == data[0]) {
                //需要两个数组 同步推移
                for (int j = 0; j < data.length; j++) {
                    //如果大str后面的长度已经不行了
                    if (data.length >= strBig.length() - i + 1) {
                        result = false;
                        break;
                    }
                    if (data[j] == dataBig[tempIndex++]) {
                        result = true;
                    } else {
                        result = false;
                        break;
                    }
                }
                if (result) {
                    break;
                }
            }
        }

        System.out.println("result:" + result);
    }


    /**
     * 这个是否包含的算法就清晰多了
     */
    static void isContainedNew(String strBig, String str) {
        boolean result = false;
        char[] dataBig = strBig.toCharArray();
        char[] data = str.toCharArray();
        for (int i = 0; i < dataBig.length; i++) {
            if (dataBig[i] == data[0]) {
                result = isEqualStart(dataBig, data, i);
                if (result) {
                    break;
                }
            }
        }

        System.out.println("result:" + result);
    }

    /**
     * 两个数组的开始部分是不是相同
     * offSize 是大数目的偏移量
     */
    private static boolean isEqualStart(char[] charsBig, char[] charsSmall, int offSize) {
        if (charsBig.length - offSize < charsSmall.length) {
            return false;
        }
        int length = Math.min(charsBig.length - offSize, charsSmall.length);
        for (int i = 0; i < length; i++) {
            if (charsBig[i + offSize] != charsSmall[i]) {
                return false;
            }
        }
        return true;
    }

}
