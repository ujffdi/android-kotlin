package com.jwsr.baselib.base.popupwindow

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import com.jwsr.baselib.base.api.IBaseView

/**
 * @author Tongsr
 * @date 2019/3/5
 * @deprecated BasePopupWindow
 * @version 1.0
 * @email ujffdtfivkg@gmail.com
 */
abstract class BasePopupWindow(context: Context) : PopupWindow(context), IBaseView {

    /**
     * root view
     */
    private val mRootView: View by lazy {
        LayoutInflater.from(context).inflate(onBindLayout(), null)
    }

    init {
        this.contentView = mRootView
        mRootView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        this.height = ViewGroup.LayoutParams.WRAP_CONTENT
        this.setBackgroundDrawable(ColorDrawable())
        this.isFocusable = true
        this.doBusiness()
    }
}