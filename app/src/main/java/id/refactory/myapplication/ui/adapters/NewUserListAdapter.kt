package id.refactory.myapplication.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.refactory.domain.NewUser
import id.refactory.myapplication.R

class NewUserListAdapter(
    private val context: Context,
    private val users: MutableList<NewUser>,
    private val event: (NewUser) -> Unit
) : RecyclerView.Adapter<NewUserListAdapter.ViewHolder>() {

    override fun getItemCount(): Int = users.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.new_users_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.tvNewUserName?.text = user.name
        holder.tvNewUserEmail?.text = user.email
        holder.itemView.setOnClickListener {
            event.invoke(user)
        }
    }

    inner class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var tvNewUserName: TextView? = null
        var tvNewUserEmail: TextView? = null

        init {
            tvNewUserName = row.findViewById(R.id.tv_new_user_name) as TextView
            tvNewUserEmail = row.findViewById(R.id.tv_new_user_email) as TextView
        }
    }
}