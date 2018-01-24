package ru.evotor.techtalks.t20180125

import org.junit.Test

/**
 * Нужно чтобы было
 * First 0
 * Second 0
 * First 1
 * Second 1
 * First 2
 * Second 2
 */
class KotlinIteratorTest {

    @Test
    fun test1() {
        (0..2)
                .map {
                    println("First $it")
                    it
                }
                .map {
                    println("Second $it")
                    it
                }
    }

    @Test
    fun test2() {
        (0..2)
                .asSequence()
                .map {
                    println("First $it")
                    it
                }
                .map {
                    println("Second $it")
                    it
                }
    }

    @Test
    fun test3() {
        (0..2)
                .asSequence()
                .map {
                    println("First $it")
                    it
                }
                .forEach {
                    println("Second $it")
                }
    }
}