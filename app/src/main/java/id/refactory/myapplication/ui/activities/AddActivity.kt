package id.refactory.myapplication.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.refactory.data.payload.api.news.NewsRequesttData
import id.refactory.domain.News
import id.refactory.myapplication.R
import id.refactory.myapplication.ui.presenters.AddPresenter
import id.refactory.myapplication.ui.views.AddView
import kotlinx.android.synthetic.main.activity_add.*
import org.jetbrains.anko.toast

class AddActivity : AppCompatActivity(), AddView.View {

    private val presenter = AddPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        onPrepare()
    }

    override fun onSuccessSubmitNews(news: News) {
        toast(news.title.toString())
    }

    override fun onPrepare() {
        submitButton?.setOnClickListener {
            presenter.onLoadSubmitNews(
                NewsRequesttData(
                    titleEditText.text.toString().trim(),
                    descriptionEditText.text.toString().trim()
                )
            )
        }
    }

    override fun onError() {
        toast("Error happen")
    }
}