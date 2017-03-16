package pattern.factory;

/**
 * Created by yahier on 17/2/28.
 */

public class AudiCarFactory extends AudiFactory {
    @Override
    public <T extends AudiCar> T createAudiCar(Class<T> clz) {
        AudiCar car = null;
        try {
            car = (AudiCar) Class.forName(clz.getName()).newInstance();
            //return (T) AudiQ3.class.newInstance(); 这样也可以返回对象
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T) car;

    }
}
