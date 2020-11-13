package id.refactory.myapplication.ui.activities

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import id.refactory.domain.NewUser
import id.refactory.myapplication.R
import id.refactory.myapplication.ui.presenters.ShowUserPresenter
import id.refactory.myapplication.ui.views.ShowUserView
import kotlinx.android.synthetic.main.activity_show_user.*
import org.jetbrains.anko.toast

class ShowUserActivity : AppCompatActivity(), ShowUserView.View {
    private val presenter = ShowUserPresenter(this)
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_user)
        onPrepare()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSuccessLoadUser(user: NewUser) {
        nameTextView?.text = user.name
        emailTextView?.text = user.email
        genderTextView?.text = user.gender
        statusTextView?.text = user.status
        endLoading()
    }

    override fun onLoading(bool: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onPrepare() {
        supportActionBar?.title = "Show New User"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent?.getLongExtra("data", -1) ?: -1
        presenter.onLoadUser(id.toInt())

        editButton?.setOnClickListener {
            startActivity(
                Intent(this, EditUserActivity::class.java)
                    .putExtra("data", id)
            )
        }
    }

    override fun onResume() {
        super.onResume()
        startLoading()
        val id = intent?.getLongExtra("data", -1) ?: -1
        presenter.onLoadUser(id.toInt())
    }

    override fun onError() {
        endLoading()
        toast("Error happen")
    }

    private fun startLoading() {
        progressDialog = ProgressDialog(this)
        progressDialog?.setTitle("Refactory.id")
        progressDialog?.setMessage("Application is loading, please wait")
        progressDialog?.show()
    }

    private fun endLoading() {
        progressDialog?.dismiss()
    }
}