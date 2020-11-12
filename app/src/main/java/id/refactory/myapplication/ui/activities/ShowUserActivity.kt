package id.refactory.myapplication.ui.activities

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.refactory.domain.NewUser
import id.refactory.myapplication.R
import id.refactory.myapplication.ui.presenters.ShowUserPresenter
import id.refactory.myapplication.ui.views.ShowUserView
import org.jetbrains.anko.toast

class ShowUserActivity : AppCompatActivity(), ShowUserView.View {
    private val presenter = ShowUserPresenter(this)
    private var progressDialog: ProgressDialog? = ProgressDialog(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_user)
        onPrepare()
    }

    override fun onSuccessLoadUser(users: NewUser) {
        TODO("Not yet implemented")
    }

    override fun onPrepare() {
        supportActionBar?.title = "Show New User"
        val id = intent?.getIntExtra("data", -1) ?: -1
        presenter.onLoadUser(id)
    }

    override fun onError() {
        toast("Error happen")
    }
}