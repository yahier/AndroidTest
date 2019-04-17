package myutil;

import java.util.UUID;

public class SimpleTest {

    public static void main(String[] args) {
        testUUID();

    }

    /**
     * UUID 唯一通用标识码，组成部分是时间 时钟序列 全局唯一的IEEE机器识别号
     * UUID的标准型式包含32个16进制数字，以连字号分为五段，形式为8-4-4-4-12的32个字符。示例：
     * 550e8400-e29b-41d4-a716-446655440000
     */
    private static void testUUID() {
        System.out.println("UUID:" + UUID.randomUUID().toString());
    }
}
