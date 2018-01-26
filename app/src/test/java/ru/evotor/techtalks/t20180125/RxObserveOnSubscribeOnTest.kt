package ru.evotor.techtalks.t20180125

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Test

class RxObserveOnSubscribeOnTest {
    fun printThread(prefix: String) = Thread.currentThread().name.let { println("$prefix $it") }

    @Test
    fun test1() {
        Observable.just(1)
                .subscribeOn(Schedulers.computation())
                .subscribe({ printThread("subscribe") })
        Thread.sleep(1000)
    }

    @Test
    fun test2() {
        Observable.just(1)
                .subscribeOn(Schedulers.computation())
                .subscribeOn(Schedulers.io()) //новая строка
                .subscribe({ printThread("subscribe") })
        Thread.sleep(1000)
    }

    @Test
    fun test3() {
        Observable.just(1)
                .observeOn(Schedulers.computation()) // новая строка
                .subscribe({ printThread("subscribe") })
        Thread.sleep(1000)
    }

    @Test
    fun test4() {
        Observable.just(1)
                .observeOn(Schedulers.computation())
                .subscribeOn(Schedulers.io())// новая строка
                .subscribe({ printThread("subscribe") })
        Thread.sleep(1000)
    }

    @Test
    fun test5() {
        Observable.just(1)
                .doOnNext { printThread("1") }
                .observeOn(Schedulers.computation())
                .doOnNext { printThread("2") }
                .subscribeOn(Schedulers.io())
                .doOnNext { printThread("3") }
                .subscribe({ printThread("subscribe") })
        Thread.sleep(1000)
    }
}