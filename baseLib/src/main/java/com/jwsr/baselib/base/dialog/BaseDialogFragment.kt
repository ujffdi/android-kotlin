package com.jwsr.baselib.base.dialog

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jwsr.baselib.R
import com.tongsr.kotlindemo.base.api.IBaseView
import com.trello.rxlifecycle2.components.support.RxAppCompatDialogFragment

/**
 * <pre>
 *     time   : 2019/1/15 下午2:07
 *     desc   : dialogFragment基类
 *     version: 1.0
 * </pre>
 * @author Tongsr
 */
abstract class BaseDialogFragment : RxAppCompatDialogFragment(), IBaseView {

    protected var isInit = false
    protected lateinit var mActivity: Activity
    protected lateinit var mContext: Context

    override fun onAttach(context: Context) {
        mContext = context
        super.onAttach(context)
        mActivity = context as Activity
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.dialog)

    }

    override fun onCreateView(inflater: LayoutInflater
                              , container: ViewGroup?
                              , savedInstanceState: Bundle?): View? {
        return inflater.inflate(onBindLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            onParseIntent(it)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isInit = true
        doBusiness()
    }

    /**
     * 初始化数据
     *
     * @param bundle 传递过来的 bundle
     */
    protected open fun onParseIntent(bundle: Bundle) {

    }
}