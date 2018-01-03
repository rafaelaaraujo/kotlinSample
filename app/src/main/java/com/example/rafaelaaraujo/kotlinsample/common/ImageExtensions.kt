package com.example.rafaelaaraujo.kotlinsample.common

import android.support.v4.content.ContextCompat
import android.widget.ImageView
import com.example.rafaelaaraujo.kotlinsample.R
import com.squareup.picasso.Picasso

/**
 * Created by rafaela.araujo
 * on 03/01/18.
 */
 fun ImageView.loadUrl(url: String) {
  Picasso.with(this.context).load(url).placeholder(ContextCompat.getDrawable(this.context, R.drawable.ic_crop)).into(this)
}