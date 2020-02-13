package com.example.testgridlayout.data.api

import android.content.Intent
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import io.reactivex.*
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type


class RxRetryCallAdapter<R>(private val originalAdapter : CallAdapter<R, *>) : CallAdapter<R, Any> {
    override fun adapt(call : Call<R>) : Any {
        val adaptedValue = originalAdapter.adapt(call)
        return when (adaptedValue) {
            is Completable -> {
                adaptedValue.doOnError(this::sendBroadcast)
                    .retryWhen {
                        Provider.provideRetrySubject().toFlowable(BackpressureStrategy.LATEST)
                            .observeOn(Schedulers.io())
                    }
            }
            is Single<*> -> {
                adaptedValue.doOnError(this::sendBroadcast)
                    .retryWhen {
                        Provider.provideRetrySubject().toFlowable(BackpressureStrategy.LATEST)
                            .observeOn(Schedulers.io())
                    }
            }
            is Maybe<*> -> {
                adaptedValue.doOnError(this::sendBroadcast)
                    .retryWhen {
                        Provider.provideRetrySubject().toFlowable(BackpressureStrategy.LATEST)
                            .observeOn(Schedulers.io())
                    }
            }
            is Observable<*> -> {
                adaptedValue.doOnError(this::sendBroadcast)
                    .retryWhen {
                        Provider.provideRetrySubject()
                            .observeOn(Schedulers.io())
                    }
            }
            is Flowable<*> -> {
                adaptedValue.doOnError(this::sendBroadcast)
                    .retryWhen {
                        Provider.provideRetrySubject().toFlowable(BackpressureStrategy.LATEST)
                            .observeOn(Schedulers.io())
                    }
            }
            else -> {
                adaptedValue
            }
        }
    }

    override fun responseType() : Type = originalAdapter.responseType()

    private fun sendBroadcast(throwable : Throwable) {

        // TODO send msg to Activity
        // Log.println(throwable.localizedMessage)
        // Timber.e(throwable)
        LocalBroadcastManager.getInstance(Provider.appInstance).sendBroadcast(Intent("TODO" /* BaseActivity.ERROR_ACTION*/ ))
    }
}