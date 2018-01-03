package com.example.rafaelaaraujo.kotlinsample.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.Menu
import com.example.rafaelaaraujo.kotlinsample.R
import com.example.rafaelaaraujo.kotlinsample.model.Edge

class HomeActivity : AppCompatActivity(), HomeContract.View {

    override lateinit var presenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenter = HomePresenter(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.queryHint = "Search HashTag"
        searchView.setOnQueryTextListener(onQueryTextListner)
        return true
    }

    override fun showErrorMessage() {
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showPosts(edges: List<Edge>) {

    }

    val onQueryTextListner = object : SearchView.OnQueryTextListener {
        override fun onQueryTextChange(newText: String): Boolean {
            return false
        }

        override fun onQueryTextSubmit(query: String): Boolean {
            presenter.loadPosts(query)
            return false
        }

    }
}
