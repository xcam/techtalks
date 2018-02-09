package ru.evotor.techtalks.t20180208

import org.junit.Assert
import org.junit.Test

class _4_2_ThrowableTestK {

/*
class MyException<T> : Throwable() {
}
*/

/*
 class MyClass<T> {
     companion object {
         fun get() : T?{
             return null
         }
     }
}
*/

/*
    object MyClass<T> {
        fun get(): T? {
            return null
        }
    }
*/

    /*
    class MyClass<T> {
        companion object {
            fun <C> get(): C? {
                return null
            }
        }
    }
    */

    /*
class MyClass<T> {
        companion object {
            fun <T> get(): T? {
                return null
            }
        }
    }
*/

    internal inner class MyException : Exception()

    internal fun <E : Exception> method() {
        throw MyException() as E
    }

    @Test
    fun testThrows() {
        try {
            method<Exception>()
            Assert.fail()
        } catch (e: Exception) {
            print("yep")
        }

    }

    @Test
    fun testRuntimeThrows() {
        this.method<RuntimeException>()
    }
}