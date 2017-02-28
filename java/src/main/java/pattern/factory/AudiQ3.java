package pattern.factory;

/**
 * Created by yahier on 17/2/28.
 */

public class AudiQ3 extends AudiCar {

    @Override
    public void drive() {
        System.out.println("Q3启动了");
    }

    @Override
    public void selfNavigation() {
        System.out.println("Q3在自动导航");
    }
}
