package com.example.rafaelaaraujo.kotlinsample.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.View
import android.widget.Toast
import com.example.rafaelaaraujo.kotlinsample.R
import com.example.rafaelaaraujo.kotlinsample.model.InstagramPost
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeContract.View {

    override lateinit var presenter: HomeContract.Presenter

    val homeAdapter = InstagramPostAdapter(this::onInstagramPostClicked)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenter = HomePresenter(this)

        instagramPostList.layoutManager = LinearLayoutManager(this)
        instagramPostList.adapter = homeAdapter
    }

    private fun onInstagramPostClicked(instagramPost: InstagramPost) {
        Toast.makeText(this, this.getString(R.string.likes_text, instagramPost.likes), Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.queryHint = "Search for a hashtag..."
        searchView.setOnQueryTextListener(onQueryTextListner)
        return true
    }

    override fun showErrorMessage() {
        instagramPostListLoading.visibility = View.GONE
        instagramPostList.visibility = View.GONE
        instagramPostError.visibility = View.VISIBLE
    }

    override fun showLoading() {
        instagramPostListLoading.visibility = View.VISIBLE
        instagramPostList.visibility = View.GONE
        instagramPostError.visibility = View.GONE
    }

    override fun hideLoading() {
        instagramPostListLoading.visibility = View.GONE
        instagramPostList.visibility = View.VISIBLE
        instagramPostError.visibility = View.GONE
    }

    override fun showPosts(instagramPosts: ArrayList<InstagramPost>) {
        homeAdapter.instagramPosts.clear()
        homeAdapter.instagramPosts.addAll(instagramPosts)
        homeAdapter.notifyDataSetChanged()
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
