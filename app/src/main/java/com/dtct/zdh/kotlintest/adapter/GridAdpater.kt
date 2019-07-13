package com.dtct.zdh.kotlintest.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.dtct.zdh.kotlintest.R

/**
 *Created by zhengdonghui1
 *on 2019-07-09
 */
class GridAdpater(private var context: Context, private var datalist: MutableList<String>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewHolder:ViewHolder
        val view: View
        if (convertView == null) {
            view = View.inflate(context,R.layout.item_gridview, null);
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        val item = getItem(position)
        if (item is String) {
            viewHolder.grid_txt.text = item

        }
        return view
    }

    override fun getItem(position: Int): Any {
        return datalist.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return datalist.size
    }

    inner class ViewHolder(viewItem: View){
        val grid_img = viewItem.findViewById<ImageView>(R.id.grid_img);
        val grid_txt = viewItem.findViewById<TextView>(R.id.grid_txt);
    }
}