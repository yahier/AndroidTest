package guava;

import com.google.common.base.Preconditions;

import apache.beanutils.User;

/**
 * Created by yahier on 10/1/18.
 */

public class PreconditionsTest {
    public static void main(String[] args) {
        test1();
    }

    //条件前置判断 Preconditions
    private static void test1() {
        User user = null;
        Preconditions.checkNotNull(user);
    }
}
