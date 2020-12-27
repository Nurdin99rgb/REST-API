package com.appcomp.app.ui.news

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.appcomp.app.R
import com.appcomp.app.data.model.News
import com.appcomp.app.databinding.ItemNewsBinding
import com.appcomp.app.ui.base.BaseAdapter
import com.bumptech.glide.Glide

class NewsAdapter (val context: Context) : BaseAdapter<News>(R.layout.item_news) {
    override fun onBind(binding: ViewDataBinding?, data: News) {
        val mBinding = binding as ItemNewsBinding
        Glide.with(context).load(data.poster).into(mBinding.itemPoster)
    }

    override fun onClick(binding: ViewDataBinding?, data: News) {
        val intent = Intent(context, NewsActivity::class.java)
        intent.putExtra(NewsActivity.OPEN_NEWS, data)
        context.startActivity(intent)
    }
}