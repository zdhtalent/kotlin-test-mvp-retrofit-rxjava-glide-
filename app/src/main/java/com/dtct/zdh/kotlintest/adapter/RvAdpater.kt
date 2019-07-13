package com.dtct.zdh.kotlintest.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import com.dtct.zdh.kotlintest.R
import kotlinx.android.synthetic.main.item_listview.view.*
import kotlinx.android.synthetic.main.item_recyclerview.view.*

/**
 *Created by zhengdonghui1
 *on 2019-07-08
 */
class RvAdapter(var date: List<String>,var context:Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 1) {
            val view = LayoutInflater.from(context).inflate(R.layout.item_listview, parent,false)
            return Holder1(view)
        } else {
            val view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview, parent,false)
            return Holder2(view)
        }
    }


    override fun getItemCount(): Int {
        return date.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is Holder1) {
            holder.bind(date[position])
        } else if (holder is Holder2) {
            holder.bind(date[position])
        }
    }

    class Holder1(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(date: String) {
            itemView.listview_txt.text = date
        }
    }

    override fun getItemViewType(position: Int): Int {
//        when(position){
//            //多布局
//            if (position%2):Int == 1 ->
//                return 1
//            else ->
//                return 0
//        }
        if (position % 2 == 1)
            return 1
        else
            return 0

    }

    class Holder2(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(date: String) {
            itemView.rv_txt.text = date
        }
    }

}