package pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import myutil.Log;

/**
 * Created by yahier on 17/2/28.
 * JDK动态代理
 */

public class DynamicProxyTest {
    static String TAG = "DynamicProxyTest";

    public static void main(String[] args) {
        test2();
    }

    static void test1() {
        UserService userService = new UserServiceImpl();
        InvocationHandler invocationHandler = new MyInvocationHandler(userService);

        //以下2选1
        //Class[] classes = userService.getClass().getInterfaces();
        Class[] classes = new Class[]{UserService.class};
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), classes, invocationHandler);
        System.out.println(userServiceProxy.getName());
    }


    static void test2() {
        Class[] classes = new Class[]{UserService.class};
        Object object = Proxy.newProxyInstance(UserService.class.getClassLoader(), classes, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                Object result = method.invoke(o, objects);
                Log.e(TAG, "result:" + result);
                return result;
            }
        });

    }

}
