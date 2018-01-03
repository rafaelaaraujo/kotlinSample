package com.example.rafaelaaraujo.kotlinsample.common


interface BaseView<T> {

    var presenter: T

    fun showErrorMessage()

    fun showLoading()

    fun hideLoading()

}