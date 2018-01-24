package java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Created by yahier on 2018/1/23.
 * Files类真厉害啊
 */

public class Java7File {
    static String filePath = "/Users/yahier/Desktop/test";
    static String filePath2 = "/Users/yahier/Desktop/test2";

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    //测试Files对文件的读写
    static void test1() {
        try {
            byte[] data = Files.readAllBytes(Paths.get(filePath));
            println("test1", new String(data));

            List<String> list = Files.readAllLines(Paths.get(filePath));
            list.forEach(System.out::println);

            //测试写入
            Files.write(Paths.get(filePath2), "如何面对，曾一起走过的日期".getBytes());
            //按行写入
            //List<String> cons = new ArrayList<>();
            //Files.write(Paths.get(filePath2), cons);
            //追加内容
            Files.write(Paths.get(filePath2), "\n现在剩下我独行，如何让心声一一讲你知".getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建文件 文件夹
    static void test2() {
        try {
            //创建文件
            Path path1 = Paths.get("/Users/yahier/Desktop/test3");
            if (!Files.exists(path1)) {
                Files.createFile(path1);//创建文件
            }

            //创建文件夹 必须要上层存在
            Path path2 = Paths.get("/Users/yahier/Desktop/yaya");
            if (!Files.exists(path2)) {
                Files.createDirectory(path2);
            }

            //创建文件夹
            Path path3 = Paths.get("/Users/yahier/Desktop/y3/y3");
            if (!Files.exists(path3)) {
                Files.createDirectories(path3);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //复制 移动 删除文件
    static void test3() {
        try {
            //复制  后面一个可选参数表示存在则替换
            Files.copy(Paths.get(filePath), Paths.get(filePath2), StandardCopyOption.REPLACE_EXISTING);
            //移动  后面一个可选参数表示原子操作，要么移动成功，要么源文件存在
            Files.move(Paths.get(filePath), Paths.get(filePath2), StandardCopyOption.ATOMIC_MOVE);
            //删除文件
            Files.deleteIfExists(Paths.get(filePath2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void println(String tag, String value) {
        System.err.println(tag + "," + value);
    }
}
