package string;

/**
 * Created by yahier on 2018/8/2.
 */

public class StringUtil {

    public final static void main(String[] args) {
        String result = saveTwoDecimal(1.245);
        System.err.println("result:" + result);
    }

    /**
     * @param b byte
     * @return String
     */
    public static String Bytes2HexString(byte b) {
        String ret = "";
        String hex = Integer.toHexString(b & 0xFF);
        if (hex.length() == 1) {
            hex = '0' + hex;
        }
        ret += hex.toUpperCase();
        return ret;
    }

    /**
     * @param b byte[]
     * @return String
     */
    public static String Bytes2HexString(byte[] b) {
        StringBuilder builder = new StringBuilder();
        for (byte item : b) {
            String hex = Integer.toHexString(item & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            builder.append(hex.toUpperCase());
        }
        return builder.toString();
    }

    public static String formatBytes(byte[] b) {
        StringBuilder builder = new StringBuilder();
        for (byte item : b) {
            String hex = Integer.toHexString(item & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            builder.append(hex.toUpperCase());
            builder.append(" ");
        }
        return builder.toString();
    }

    public static String saveTwoDecimal(double value) {
        return String.format("%.2f", value);
    }
}
