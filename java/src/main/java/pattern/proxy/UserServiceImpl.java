package pattern.proxy;

/**
 * Created by yahier on 17/2/28.
 */

public class UserServiceImpl implements UserService {
    @Override
    public String getName() {
        System.out.println("------getName------");
        return "Tom";
    }



}
