package ru.evotor.techtalks.t20180222

import io.reactivex.Single
import io.reactivex.SingleEmitter
import io.reactivex.SingleOnSubscribe
import io.reactivex.schedulers.Schedulers
import org.junit.Test
import java.lang.Thread.sleep

class LittleDialog<T> private constructor(val message: String) : SingleOnSubscribe<T> {
    override fun subscribe(e: SingleEmitter<T>) {
        throw IllegalArgumentException("something wrong")
    }

    companion object {
        fun getSingle(message: String): Single<String> {
            return Single.create(LittleDialog<String>(message)).subscribeOn(Schedulers.io())
        }
    }
}

class _1_RxStackTrace {
    @Test
    fun test() {
        LittleDialog.getSingle("my message").subscribe()

        sleep(100)
    }
}
