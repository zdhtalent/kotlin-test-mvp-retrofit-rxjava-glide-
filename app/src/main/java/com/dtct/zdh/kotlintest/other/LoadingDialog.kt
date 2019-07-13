package com.dtct.zdh.kotlintest.other

import android.app.AlertDialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.text.TextUtils
import android.widget.ImageView
import android.widget.TextView
import com.dtct.zdh.kotlintest.R
import org.jetbrains.anko.find

/**
 * @Author :xqt
 * @Description :加载菊花
 */
class LoadingDialog : AlertDialog {
    private var mImageView: ImageView? = null
    private var mAnimation: AnimationDrawable? = null
    private var mssage: TextView? = null

    constructor(context: Context, theme: Int) : super(context, theme)

    constructor(context: Context) : super(context)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var view = layoutInflater.inflate(R.layout.dialog_loading,null)
        setContentView(view)
        mImageView = view.find(R.id.dialog_imageview)
        mssage = view.find(R.id.tvMsg)
        mAnimation = mImageView!!.background as AnimationDrawable
        mImageView!!.post { mAnimation!!.start() }
    }

    fun setLoadMsg(msg: String) {
        mssage?:return
        if (!TextUtils.isEmpty(msg))
            mssage!!.text = msg
    }
}
