package id.refactory.myapplication.ui.activities

import android.app.ProgressDialog
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import id.refactory.data.payload.api.user.NewUserApiRequest
import id.refactory.domain.NewUser
import id.refactory.myapplication.R
import id.refactory.myapplication.ui.presenters.AddUserPresenter
import id.refactory.myapplication.ui.views.AddUserView
import kotlinx.android.synthetic.main.activity_add_user.*
import org.jetbrains.anko.toast

class AddUserActivity : AppCompatActivity(), AddUserView.View {
    private val presenter = AddUserPresenter(this)
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
        onPrepare()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSuccessSubmitUser(users: NewUser) {
        endLoading()
        toast("Akun ${users.email} berhasil ditambahkan")
        finish()
    }

    override fun onLoad(load: Boolean) {
    }

    override fun onPrepare() {
        supportActionBar?.title = "Add New User"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        submitButton?.setOnClickListener {
            val email = emailEditText?.text.toString().trim()
            if (!email.contains("@refactory.id")) {
                toast("email harus menggunakan domain: refactory.id")
                return@setOnClickListener
            }
            startLoading()
            val request = NewUserApiRequest(
                name = nameEditText?.text.toString().trim(),
                email = emailEditText?.text.toString().trim(),
                gender = getGender(),
                status = getStatus()
            )
            presenter.onSubmitUser(request)
        }
    }

    private fun getStatus(): String {
        return if (activeRadioButton.isChecked) "Active" else "Inactive"
    }

    private fun getGender(): String {
        return if (wanitaRadioButton.isChecked) "Female" else "Male"
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