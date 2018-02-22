package ru.evotor.techtalks.t20180222

import io.reactivex.Single
import io.reactivex.SingleEmitter
import io.reactivex.SingleOnSubscribe
import io.reactivex.schedulers.Schedulers
import org.junit.Test

class LittleDialog3<T> private constructor(val message: String) : SingleOnSubscribe<T> {

    private val stacktraceHolder: Exception = RuntimeException()

    override fun subscribe(e: SingleEmitter<T>) {
        try {
            throw IllegalArgumentException("something wrong")
        } catch (e: Exception) {
            e.stackTrace = e.stackTrace.plus(stacktraceHolder.stackTrace)
            throw e
        }
    }

    companion object {
        fun getSingle(message: String): Single<String> {
            return Single.create(LittleDialog3<String>(message)).subscribeOn(Schedulers.io())
        }
    }
}

class _3_RxStackTrace {
    @Test
    fun test() {
        LittleDialog3.getSingle("my message").subscribe()

        Thread.sleep(100)
    }
}