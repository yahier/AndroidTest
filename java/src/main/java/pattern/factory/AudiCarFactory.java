package pattern.factory;

/**
 * Created by yahier on 17/2/28.
 */

public class AudiCarFactory extends AudiFactory {
    @Override
    public <T extends AudiCar> T createAudiCar(Class<T> clz) {
        AudiCar car = null;
        try {
            //以下2选1

            car = (AudiCar) Class.forName(clz.getName()).newInstance();
            //return (T) AudiQ3.class.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T) car;

    }
}
