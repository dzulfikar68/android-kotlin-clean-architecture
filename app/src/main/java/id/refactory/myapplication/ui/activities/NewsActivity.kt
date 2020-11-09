package id.refactory.myapplication.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.refactory.domain.News
import id.refactory.myapplication.R
import id.refactory.myapplication.ui.adapters.NewsListAdapter
import id.refactory.myapplication.ui.presenters.NewsPresenter
import id.refactory.myapplication.ui.views.NewsView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class NewsActivity : AppCompatActivity(), NewsView.View {

    private val presenter = NewsPresenter(this)
    private var news = mutableListOf<News>()
    private var adapter: NewsListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
    }

    override fun onSuccessLoadNews(news: List<News>) {
        this.news.clear()
        this.news.addAll(news)
        adapter?.notifyDataSetChanged()
    }

    override fun onPrepare() {
        rv_users.layoutManager = LinearLayoutManager(this)
        adapter = NewsListAdapter(this, news)
        rv_users.adapter = adapter
        presenter.onLoadNews(mutableMapOf())
    }

    override fun onError() {
        toast("Error happen")
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}