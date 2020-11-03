package com.nehal.awesomequotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nehal.awesomequotes.adapter.PostAdapter
import com.nehal.awesomequotes.model.Quotes
import com.nehal.awesomequotes.repository.PostRepository
import com.nehal.awesomequotes.viewModel.PostViewModel
import com.nehal.awesomequotes.viewModel.PostViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG="main"
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
        val postViewModelFactory= PostViewModelFactory(PostRepository())
        postViewModel= ViewModelProvider(this,postViewModelFactory)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.postData.observe(this, Observer {
            Log.d(TAG, "onCreate: ${it[0].quoteText}")
            postAdapter.setPostData(it as ArrayList<Quotes>)
            progressBar.visibility= View.GONE
            recyclerView.visibility= View.VISIBLE
        })
    }

    private fun initUi() {
        recyclerView=findViewById(R.id.recyclerView)
        postAdapter= PostAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=postAdapter
        }
    }

}