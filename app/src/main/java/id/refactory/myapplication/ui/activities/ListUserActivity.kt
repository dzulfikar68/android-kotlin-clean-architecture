package id.refactory.myapplication.ui.activities

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)
        onPrepare()
    }

    override fun onSuccessLoadUsers(users: List<NewUser>) {
        this.users.clear()
        this.users.addAll(users)
        adapter?.notifyDataSetChanged()
    }

    override fun onPrepare() {
        adapter = NewUserListAdapter(this, users)
        rv_new_users.layoutManager = LinearLayoutManager(this)
        rv_new_users.adapter = adapter
        presenter.onLoadUsers(mutableMapOf())
    }

    override fun onError() {
        toast("Error happen")
    }
}