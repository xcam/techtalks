package ru.evotor.techtalks.t20180503

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import java.lang.Thread.sleep


class ObservableTest {
    @Test
    fun testChain() {
        load()
                .subscribeOn(Schedulers.io())
                .concatWith(parse())
                .subscribe {
                    println("Subscribe: " + it)
                }


        sleep(5_000)
    }

    fun load(): Observable<Throwable> {
        return Observable.fromArray(XmlDocument("1"), XmlDocument("2"))
                .doOnNext { println("doOnNext!") }
                .map { RuntimeException(it.toString()) }
    }

    fun parse(): Observable<Throwable> {
        return Observable.fromArray(Document("1"), Document("2"))
                .doOnSubscribe { println("Subscribed!") }
                .map { RuntimeException(it.toString()) }
    }
}

data class XmlDocument(val someString: String)
data class Document(val someString: String)