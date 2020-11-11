package id.refactory.myapplication.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.refactory.domain.News
import id.refactory.myapplication.R
import id.refactory.myapplication.ui.presenters.ShowPresenter
import id.refactory.myapplication.ui.views.ShowView
import kotlinx.android.synthetic.main.activity_show.*
import org.jetbrains.anko.toast

class ShowActivity : AppCompatActivity(), ShowView.View {

    private val presenter = ShowPresenter(this)
    fun getId() = intent?.getLongExtra("data", 0) ?: 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)
        onPrepare()
    }

    override fun onSuccessShowNews(news: News) {
        titleTextView?.text = news.title
        descriptionTextView?.text = news.description
    }

    override fun onPrepare() {
        supportActionBar?.title = "Show News"
        presenter.onLoadShowNews(getId().toInt())
        editButton?.setOnClickListener {
            startActivity(
                Intent(this, EditActivity::class.java)
                    .putExtra("data", getId())
            )
        }
    }

    override fun onError() {
        toast("Error happen")
    }
}