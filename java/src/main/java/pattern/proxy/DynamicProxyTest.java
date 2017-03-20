package pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by yahier on 17/2/28.
 */

public class DynamicProxyTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        InvocationHandler invocationHandler = new MyInvocationHandler(userService);

        //以下2选1
        Class[] classes = userService.getClass().getInterfaces();
        Class[] classes2 = new Class[]{UserService.class};

        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                classes2, invocationHandler);

        System.out.println(userServiceProxy.getName(1));
    }


}
