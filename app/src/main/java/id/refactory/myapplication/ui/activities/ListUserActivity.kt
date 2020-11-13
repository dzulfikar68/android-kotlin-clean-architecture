package id.refactory.myapplication.ui.activities

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import id.refactory.domain.NewUser
import id.refactory.myapplication.R
import id.refactory.myapplication.ui.adapters.NewUserListAdapter
import id.refactory.myapplication.ui.presenters.ListUserPresenter
import id.refactory.myapplication.ui.views.ListUserView
import kotlinx.android.synthetic.main.activity_list_user.*
import org.jetbrains.anko.toast

class ListUserActivity : AppCompatActivity(), ListUserView.View {
    private val presenter = ListUserPresenter(this)
    private var users = mutableListOf<NewUser>()
    private var adapter: NewUserListAdapter? = null
    private var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)
        supportActionBar?.title = "CRUD email khusus @refactory.id"
        onPrepare()
    }

    override fun onSuccessLoadUsers(users: List<NewUser>) {
        endLoading()
        this.users.clear()
        this.users.addAll(users)
        adapter?.notifyDataSetChanged()
    }

    override fun onLoad(load: Boolean) {
    }

    private val onClickItem: (NewUser) -> Unit = {
        startActivity(
            Intent(this, ShowUserActivity::class.java)
                .putExtra("data", it.id)
        )
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

    override fun onPrepare() {
        adapter = NewUserListAdapter(this, users, onClickItem)
        rv_new_users.layoutManager = LinearLayoutManager(this)
        rv_new_users.adapter = adapter
        addButton?.setOnClickListener {
            startActivity(
                Intent(this, AddUserActivity::class.java)
            )
        }
    }

    override fun onResume() {
        super.onResume()
        startLoading()
        presenter.onLoadUsers(
            mutableMapOf(
                "email" to "refactory.id"
            )
        )
    }

    override fun onError() {
        endLoading()
        toast("Error happen")
    }
}