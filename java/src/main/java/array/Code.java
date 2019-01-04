package array;

/**
 * 自定义的英文和数字转码(在索引中找到值，固定位置转移)
 */
public class Code {
    private static char[] base64EncodeChars = new char[]{'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/'};

    private final static int offSize = 3;

    public static void main(String[] args) {
        String value = "yahier";

        value = addIndex(value);
        System.out.println("增加偏移量后的数据:" + value);

        value = subIndex(value);
        System.out.println("减少偏移量后的数据:" + value);

    }

    /**
     * 获取增加偏移量后的值
     */
    private static String addIndex(String str) {
        StringBuffer sb = new StringBuffer();
        char[] data = str.toCharArray();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < base64EncodeChars.length; j++) {
                if (base64EncodeChars[j] == data[i]) {
                    sb.append(base64EncodeChars[j + offSize]);
                    continue;
                }
            }
        }
        return sb.toString();
    }

    /**
     * 获取减少偏移量后的值
     */
    private static String subIndex(String str) {
        StringBuffer sb = new StringBuffer();
        char[] data = str.toCharArray();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < base64EncodeChars.length; j++) {
                if (base64EncodeChars[j] == data[i]) {
                    sb.append(base64EncodeChars[j - offSize]);
                    continue;
                }
            }
        }
        return sb.toString();
    }
}
