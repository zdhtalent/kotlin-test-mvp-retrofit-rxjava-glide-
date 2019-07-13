package com.dtct.zdh.kotlintest.mvp.presenter

import android.util.Log
import com.dtct.zdh.kotlintest.http.RetrofitUtil
import com.dtct.zdh.kotlintest.mvp.GirlContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 *Created by zhengdonghui1
 *on 2019-07-12
 */
class GrilPresenter(val view:GirlContract.View) : GirlContract.Presenter{
    var compositeDisposable: CompositeDisposable

    companion object {
        const val TAG = "dtct"
    }

    init {
        view.presenter = this
        compositeDisposable= CompositeDisposable()
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
        compositeDisposable.clear()
    }


    override fun getMeiziData() {
        val disposable = RetrofitUtil
            .retrofitService
            .getMeizi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                view.showMeiziData(result)
                Log.i(TAG, result.toString())
            }, { error ->
                view.showError(error.message.toString())
                Log.i(TAG, error.message.toString())
            })
        compositeDisposable.add(disposable)
    }

}