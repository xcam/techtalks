package ru.evotor.techtalks.t20180222

import org.junit.Test
import java.lang.Thread.sleep

class Cursor() {
    private var closed = false

    fun hasNext() = true
    fun next() {
        if(closed){
            throw IllegalStateException("cursor already closed")
        }
        Object()
    }

    fun close() {
        closed = true
    }
}

fun someExpression() = true

class CursorTest {
    var cursor: Cursor? = null

    fun pauseIfNeeded() {
        if (someExpression()) {
            cursor?.close()
            sleep(1000)
            cursor = Cursor()
        }
    }

    @Test
    fun test() {
        cursor = Cursor()

        cursor?.let { cursor ->
            while (cursor.hasNext()) {
                cursor.next()
                //doSomeWork
                pauseIfNeeded()

                println("iteration")
            }
        }
    }

}