package pattern.factory;

/**
 * Created by yahier on 17/2/28.
 */

public class Client {
    public final static void main(String[] args) {
        AudiCarFactory factory = new AudiCarFactory();
        AudiQ3 audiQ3 = factory.createAudiCar(AudiQ3.class);
        audiQ3.drive();
        audiQ3.selfNavigation();
    }
}
