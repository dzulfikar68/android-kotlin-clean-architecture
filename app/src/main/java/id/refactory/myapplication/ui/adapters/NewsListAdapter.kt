package id.refactory.myapplication.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.refactory.domain.News
import id.refactory.myapplication.R

class NewsListAdapter(
    private val context: Context,
    private val news: MutableList<News>
) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    override fun getItemCount(): Int = news.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = news[position]
        holder.tvNewsTitle?.text = user.title
        holder.tvNewsDescription?.text = user.description
    }

    inner class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var tvNewsTitle: TextView? = null
        var tvNewsDescription: TextView? = null

        init {
            tvNewsTitle = row.findViewById(R.id.tv_news_title) as TextView
            tvNewsDescription = row.findViewById(R.id.tv_news_description) as TextView
        }
    }
}