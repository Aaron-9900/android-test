package com.example.testcivitatis.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewHolder<in T>(override val containerView: View): RecyclerView.ViewHolder(containerView),
    LayoutContainer {
    abstract fun bind(item: T)
}