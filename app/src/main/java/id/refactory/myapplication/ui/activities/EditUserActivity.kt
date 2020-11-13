package id.refactory.myapplication.ui.activities

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import id.refactory.data.payload.api.user.NewUserApiRequest
import id.refactory.domain.NewUser
import id.refactory.myapplication.R
import id.refactory.myapplication.ui.presenters.EditUserPresenter
import id.refactory.myapplication.ui.views.EditUserView
import kotlinx.android.synthetic.main.activity_edit_user.*
import org.jetbrains.anko.toast

class EditUserActivity : AppCompatActivity(), EditUserView.View {
    private val presenter = EditUserPresenter(this)
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user)
        onPrepare()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSuccessSubmitUser(user: NewUser) {
        endLoading()
        toast("edit user email ${user.email} berhasil")
        finish()
    }

    override fun onSuccessShowUser(user: NewUser) {
        nameEditText?.setText(user.name)
        emailEditText?.setText(user.email)
        setGender(user.gender)
        setStatus(user.status)
        endLoading()
    }

    override fun onSuccessDeleteUser(user: NewUser) {
        endLoading()
        toast("delete user email ${user.email} berhasil")
        val intent = Intent(this, ListUserActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun onPrepare() {
        supportActionBar?.title = "Edit New User"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        startLoading()
        val id = intent?.getLongExtra("data", -1) ?: -1
        presenter.onShowUser(id.toInt())

        editButton?.setOnClickListener {
            val email = emailEditText?.text.toString().trim()
            if (!email.contains("@refactory.id")) {
                toast("email harus menggunakan domain: refactory.id")
                return@setOnClickListener
            }
            startLoading()
            presenter.onSubmitUser(
                id.toInt(),
                NewUserApiRequest(
                    name = nameEditText?.text.toString().trim(),
                    email = emailEditText?.text.toString().trim(),
                    gender = getGender(),
                    status = getStatus()
                )
            )
        }
        deleteButton?.setOnClickListener {
            startLoading()
            presenter.onDeleteUser(id.toInt())
        }
    }

    private fun setStatus(input: String?) {
        if (input == "Active") activeRadioButton.isChecked = true
        if (input == "Inactive") notActiveRadioButton.isChecked = true
    }

    private fun setGender(input: String?) {
        if (input == "Male") priaRadioButton.isChecked = true
        if (input == "Female") wanitaRadioButton.isChecked = true
    }

    private fun getStatus(): String {
        return if (activeRadioButton.isChecked) "Active" else "Inactive"
    }

    private fun getGender(): String {
        return if (wanitaRadioButton.isChecked) "Female" else "Male"
    }

    override fun onError() {
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