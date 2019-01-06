package com.yahier.androidtest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void test0() throws Exception {
        System.out.println("test0");
    }

    /**
     * @Ignore表示此方法被忽略
     */
    @Ignore
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.err.println("test2");
    }

    /**
     * @Before 表示此方法在 每个被Test标记的方法调用前，都会调用.与之对应的是 @After
     */
    @Before
    public void test3() {
        System.out.println("test3");
    }

    /**
     * @BeforeClass 在执行测试类的所有测试方法前，会先执行此方法，注意需static
     */
    @BeforeClass
    public static void test4() {
        System.err.println("test4");
    }
}