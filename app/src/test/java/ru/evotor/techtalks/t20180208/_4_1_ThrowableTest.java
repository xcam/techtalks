package ru.evotor.techtalks.t20180208;

import org.junit.Assert;
import org.junit.Test;

public class _4_1_ThrowableTest {

    /*
    class MyException2<T> extends _4_1_ThrowableTest {
    }

    class MyException<T> extends Throwable {
    }
    /**/


    /*
    static class MyClass<T> {
        public static T get(){
            return null;
        }
    }
    /**/

    /*
    static class MyClass<T> {
        public static <C> C get() {
            return null;
        }
    }
    /**/

    /*
    static class MyClass<T> {
        public static <T> T get() {
            return null;
        }
    }
    /**/

    class MyException extends Exception {

    }

    <E extends Exception> void method() throws E {
        throw (E) new MyException();
    }

    @Test
    public void testThrows() {
        try {
            method();
            Assert.fail();
        } catch (Exception e) {
            System.out.print("yep");
        }
    }

    @Test
    public void testRuntimeThrows() {
        this.<RuntimeException>method();
    }

}
