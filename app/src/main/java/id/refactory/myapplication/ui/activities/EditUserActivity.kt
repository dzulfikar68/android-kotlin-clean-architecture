package id.refactory.myapplication.ui.activities

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
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

    override fun onSuccessSubmitUser(user: NewUser) {
        toast("edit user email ${user.email} berhasil")
    }

    override fun onSuccessShowUser(user: NewUser) {
        nameEditText?.setText(user.name)
        emailEditText?.setText(user.email)
        setGender(user.gender)
        setStatus(user.status)
    }

    override fun onSuccessDeleteUser(user: NewUser) {
        toast("delete user email ${user.email} berhasil")
        val intent = Intent(this, ListUserActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    override fun onPrepare() {
        supportActionBar?.title = "Edit New User"
        val id = intent?.getLongExtra("data", -1) ?: -1
        presenter.onShowUser(id.toInt())
        editButton?.setOnClickListener {
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
}