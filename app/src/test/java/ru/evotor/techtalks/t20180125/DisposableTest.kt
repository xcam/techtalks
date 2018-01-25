package ru.evotor.techtalks.t20180125

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import java.lang.Exception
import java.lang.Thread.sleep

class DisposableTest {
    @Test
    fun test1() {
        val disposable =
                Observable.just(1)
                        .subscribeOn(Schedulers.io())
                        .doOnNext { println("started!") }
                        .map {
                            println("sleep!")
                            sleep(1000) // <- Здесь должна произойти отписка
                        }
                        .map { println("map!") }
                        .subscribe(
                                { println("onNext!") },
                                { println("onError!") },
                                { println("onComplete!") }
                        )

        sleep(200)
        disposable.dispose()
        println("!!!disposed!!!")
    }

    @Test
    fun test2() {
        val disposable =
                Observable.just(1)
                        .subscribeOn(Schedulers.io())
                        .doOnNext { println("started!") }
                        .map {
                            println("sleep!")
                            sleep(1000) // <- Здесь должна произойти отписка
                        }
                        .map { println("map!") }
                        .doAfterTerminate { println("AfterTerminate!") } // новая строка
                        .subscribe(
                                { println("onNext!") },
                                { println("onError!") },
                                { println("onComplete!") }
                        )

        sleep(200)
        disposable.dispose()
        println("!!!disposed!!!")
    }

    @Test
    fun test3() {
        val disposable =
                Observable.just(1)
                        .subscribeOn(Schedulers.io())
                        .doOnNext { println("started!") }
                        .map {
                            println("sleep!")
                            sleep(1000) // <- Здесь должна произойти отписка
                        }
                        .map { println("map!") }
                        .doOnComplete { println("doOnComplete!") } // новая строка
                        .subscribe(
                                { println("onNext!") },
                                { println("onError!") },
                                { println("onComplete!") }
                        )

        sleep(200)
        disposable.dispose()
        println("!!!disposed!!!")
    }

    @Test
    fun test4() {
        val disposable =
                Observable.just(1)
                        .subscribeOn(Schedulers.io())
                        .doOnNext { println("started!") }
                        .map {
                            println("sleep!")
                            sleep(1000) // <- Здесь должна произойти отписка
                        }
                        .map { println("map!") }
                        .doOnDispose { println("doOnDispose!") } // новая строка
                        .subscribe(
                                { println("onNext!") },
                                { println("onError!") },
                                { println("onComplete!") }
                        )

        sleep(200)
        disposable.dispose()
        println("!!!disposed!!!")
    }

    @Test
    fun test5() {
        val disposable =
                Observable.just(1)
                        .subscribeOn(Schedulers.io())
                        .doOnNext { println("started!") }
                        .map {
                            println("sleep!")
                            sleep(1000) // <- Здесь должна произойти отписка
                        }
                        .map { println("map!") }
                        .doAfterNext { println("doAfterNext!") } // новая строка
                        .subscribe(
                                { println("onNext!") },
                                { println("onError!") },
                                { println("onComplete!") }
                        )

        sleep(200)
        disposable.dispose()
        println("!!!disposed!!!")
    }

    @Test
    fun test6() {
        val disposable =
                Observable.just(1)
                        .subscribeOn(Schedulers.io())
                        .doOnNext { println("started!") }
                        .map {
                            println("sleep!")
                            sleep(1000) // <- Здесь должна произойти отписка
                            it
                        }
                        .map { println("map!") }
                        .doOnNext { println("doOnNext!") } // новая строка
                        .subscribe(
                                { println("onNext!") },
                                { println("onError!") },
                                { println("onComplete!") }
                        )

        sleep(200)
        disposable.dispose()
        println("!!!disposed!!!")
    }

    @Test
    fun test7() {
        val disposable =
                Observable.just(1)
                        .subscribeOn(Schedulers.io())
                        .doOnNext { println("started!") }
                        .map {
                            println("sleep!")
                            sleep(1000) // <- Здесь должна произойти отписка
                            it
                        }
                        .map { println("map!") }
                        .doFinally { println("doFinally!") } // новая строка
                        .subscribe(
                                { println("onNext!") },
                                { println("onError!") },
                                { println("onComplete!") }
                        )

        sleep(200)
        disposable.dispose()
        println("!!!disposed!!!")
    }

    @Test
    fun testException1() {
        val disposable =
                Observable.just(1)
                        .subscribeOn(Schedulers.io())
                        .doOnNext { println("started!") }
                        .map {
                            println("sleep!")
                            sleep(1000) // <- Здесь должна произойти отписка
                            throw Exception("Some exception") // новая строка
                        }
                        .map { println("map!") }
                        .doAfterNext { println("doAfterNext!") }
                        .subscribe(
                                { println("onNext!") },
                                { println("onError!") },
                                { println("onComplete!") }
                        )

        sleep(200)
        disposable.dispose()
        println("!!!disposed!!!")
    }

    @Test
    fun testException2() {
        val disposable =
                Observable.just(1)
                        .subscribeOn(Schedulers.io())
                        .doOnNext { println("started!") }
                        .map {
                            println("sleep!")
                            sleep(1000) // <- Здесь должна произойти отписка
                            throw Exception("Some exception")
                        }
                        .map { println("map!") }
                        .doOnError { println("doOnError!") }// новая строка
                        .subscribe(
                                { println("onNext!") },
                                { println("onError!") },
                                { println("onComplete!") }
                        )

        sleep(200)
        disposable.dispose()
        println("!!!disposed!!!")
    }

    @Test
    fun testException3() {
        val disposable =
                Observable.just(1)
                        .subscribeOn(Schedulers.io())
                        .doOnNext { println("started!") }
                        .map {
                            println("sleep!")
                            sleep(1000) // <- Здесь должна произойти отписка
                            throw Exception("Some exception")
                        }
                        .map { println("map!") }
                        .onErrorReturn {
                            // новая строка
                            println("onErrorReturn!")// новая строка
                            3// новая строка
                        }
                        .subscribe(
                                { println("onNext!") },
                                { println("onError!") },
                                { println("onComplete!") }
                        )

        sleep(200)
        disposable.dispose()
        println("!!!disposed!!!")
    }

    @Test
    fun testException4() {
        val disposable =
                Observable.just(1)
                        .subscribeOn(Schedulers.io())
                        .doOnNext { println("started!") }
                        .map {
                            println("sleep!")
                            sleep(1000) // <- Здесь должна произойти отписка
                            throw Exception("Some exception")
                        }
                        .map { println("map!") }
                        .doAfterTerminate { println("doAfterTerminate!") }// новая строка
                        .subscribe(
                                { println("onNext!") },
                                { println("onError!") },
                                { println("onComplete!") }
                        )

        sleep(200)
        disposable.dispose()
        println("!!!disposed!!!")
    }

    @Test
    fun testException5() {
        val disposable =
                Observable.just(1)
                        .subscribeOn(Schedulers.io())
                        .doOnNext { println("started!") }
                        .map {
                            println("sleep!")
                            sleep(1000) // <- Здесь должна произойти отписка
                            throw Exception("Some exception")
                        }
                        .map { println("map!") }
                        .doFinally { println("doFinally!") }// новая строка
                        .subscribe(
                                { println("onNext!") },
                                { println("onError!") },
                                { println("onComplete!") }
                        )

        sleep(200)
        disposable.dispose()
        println("!!!disposed!!!")
    }

}