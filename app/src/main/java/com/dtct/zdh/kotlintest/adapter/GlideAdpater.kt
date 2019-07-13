package com.dtct.zdh.kotlintest.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.dtct.zdh.kotlintest.GlideApp
import com.dtct.zdh.kotlintest.R
import com.dtct.zdh.kotlintest.bean.PrettyGril
import com.dtct.zdh.kotlintest.bean.Result
import java.util.*

/**
 *Created by zhengdonghui1
 *on 2019-07-08
 */
class GlideAdpater (var date: List<Result>, var context:Context) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        var viewHolder:ViewHolder
        var view: View
        if (convertView == null) {
            view = View.inflate(context,R.layout.item_girl, null);
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        val item = getItem(position)
        if (item is Result) {
            viewHolder.name.text = item.who
            viewHolder.date.text = item.desc
            viewHolder.type.text = item.type
            GlideApp.with(context)
                .load(item.url)
                .into(viewHolder.girl_img)

        }
        return view
    }

    override fun getItem(position: Int): Any {
        return date.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return date.size
    }

    class ViewHolder(viewItem: View) {
        val name : TextView = viewItem.findViewById(R.id.name)
        val date : TextView = viewItem.findViewById(R.id.date)
        val type : TextView = viewItem.findViewById(R.id.type)
        val girl_img: ImageView = viewItem.findViewById(R.id.girl_img)

    }
}