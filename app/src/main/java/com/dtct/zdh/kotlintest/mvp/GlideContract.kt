package com.dtct.zdh.kotlintest.mvp

import com.dtct.zdh.kotlintest.bean.PrettyGril
import com.dtct.zdh.kotlintest.mvp.base.BasePresenter
import com.dtct.zdh.kotlintest.mvp.base.BaseView

/**
 *Created by zhengdonghui1
 *on 2019-07-12
 */
interface GlideContract {
    interface View : BaseView<Presenter> {
        fun showMeiziData(prettyGril: PrettyGril)
        fun showError(errorMsg: String)
    }

    interface Presenter : BasePresenter {
        fun getMeiziData()
    }
}