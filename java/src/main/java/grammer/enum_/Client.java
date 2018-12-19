package grammer.enum_;

/**
 * Created by yahier on 12/19/18.
 * 测试枚举
 */

public class Client {
    public static void main(String[] args) {
        ColorEnum color = ColorEnum.BLACK;


        String desc = null;
        switch (color) {
            case RED:
                desc = color.desc;
                break;
            case GREEN:
                desc = color.desc;
                break;
            case BLACK:
                desc = color.desc;
                break;
            case YELLO:
                desc = color.desc;
                break;
        }

        System.err.println(color.type + ":" + desc);
    }

}
