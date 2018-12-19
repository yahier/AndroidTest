package grammer.enum_;

/**
 * Created by yahier on 12/19/18.
 * 枚举测试
 */

public enum ColorEnum {
    RED("红色", 1), GREEN("绿色", 2), BLACK("黑色", 3), YELLO("黄色", 4);
    int type;
    String desc;

    ColorEnum(String desc, int type) {
        this.type = type;
        this.desc = desc;
    }

}
