package id.refactory.myapplication.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.refactory.data.payload.api.news.NewsRequestData
import id.refactory.domain.News
import id.refactory.myapplication.R
import id.refactory.myapplication.ui.presenters.EditPresenter
import id.refactory.myapplication.ui.views.EditView
import kotlinx.android.synthetic.main.activity_edit.*
import org.jetbrains.anko.toast

class EditActivity : AppCompatActivity(), EditView.View {

    private var news: News? = null
    private val presenter = EditPresenter(this)
    private fun getId() = intent?.getLongExtra("data", 0) ?: 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        onPrepare()
    }

    override fun onSuccessLoadNews(news: News) {
        this.news = news
        titleEditText?.setText(news.title)
        descriptionEditText?.setText(news.description)
    }

    override fun onSuccessSubmitNews(news: News) {
        toast("sukses edit data : " + news.title)
    }

    override fun onSuccessDeleteNews(news: News) {
        toast("sukses delete data")
        val i = Intent(this, NewsActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(i)
    }

    override fun onPrepare() {
        supportActionBar?.title = "Edit News"
        presenter.onLoadShowNews(getId().toInt())
        submitButton?.setOnClickListener {
            presenter.onLoadSubmitNews(
                getId().toInt(),
                NewsRequestData(
                    id = news?.id,
                    title = news?.title,
                    body = news?.description
                )
            )
        }
        deleteButton?.setOnClickListener {
            presenter.onLoadDeleteNews(getId().toInt())
        }
    }

    override fun onError() {
        toast("something error")
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}