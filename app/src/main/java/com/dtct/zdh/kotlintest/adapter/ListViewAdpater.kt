package com.dtct.zdh.kotlintest.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.dtct.zdh.kotlintest.R
import java.util.*

/**
 *Created by zhengdonghui1
 *on 2019-07-08
 */
class ListViewAdpater (var date: List<String>, var context:Context) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        var viewHolder:ViewHolder
        var view: View
        if (convertView == null) {
            view = View.inflate(context,R.layout.item_listview, null);
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        val item = getItem(position)
        if (item is String) {
            viewHolder.listview_txt.text = item

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
        var listview_img: ImageView = viewItem.findViewById(R.id.listview_img)
        var listview_txt: TextView = viewItem.findViewById(R.id.listview_txt)

    }
}