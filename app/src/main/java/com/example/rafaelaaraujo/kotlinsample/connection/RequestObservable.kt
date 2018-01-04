package com.example.rafaelaaraujo.kotlinsample.connection

import com.example.rafaelaaraujo.kotlinsample.BuildConfig
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.internal.functions.ObjectHelper
import io.reactivex.internal.operators.observable.ObservableJust
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers


/**
 * Created by thiago on 04/01/18.
 */
class RequestObservable<T> : Observable<T>() {

    override fun subscribeActual(observer: Observer<in T>?) {
        subscribeActual(observer)
    }

    fun prepareObservable() : Observable<T> {
        if (!isTesting()) {
            return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        } else {
            return subscribeOn(Schedulers.trampoline()).observeOn(Schedulers.trampoline())
        }
    }

    private fun isTesting(): Boolean {
        try {
            Class.forName("com.example.rafaelaaraujo.kotlinsample.HomePresenterUnitTest")
            return true
        } catch (e: ClassNotFoundException) {
            return false
        }
    }

}