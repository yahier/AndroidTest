package pattern.model;

/**
 * Created by yahier on 12/19/18.
 * 测试模板模式 模拟升级
 */

public class Client {

    public static void main(String[] args) {
        UpdateManager updateManager = new UpdateManager();
        updateManager.execute();


        //模拟主线程一直运行
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程跑啊跑");
        }
    }
}
