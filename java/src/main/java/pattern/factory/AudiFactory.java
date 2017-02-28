package pattern.factory;

/**
 * Created by yahier on 17/2/28.
 */

public abstract class AudiFactory {
    public abstract <T extends AudiCar> T createAudiCar(Class<T> clz);
}
