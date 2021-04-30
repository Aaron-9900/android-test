package com.example.testcivitatis.viewholders

import android.provider.Settings.Global.getString
import android.util.Log
import android.view.View
import com.example.testcivitatis.R
import com.example.testcivitatis.repository.localtypes.JobPosting
import com.example.testcivitatis.utils.toFormattedString
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.job_posting_view_holder.view.*

class JobViewHolder(containerView: View, private val onPress: (jobPosting: JobPosting) -> Unit): BaseViewHolder<JobPosting>(containerView) {
    override fun bind(item: JobPosting) {
        containerView.job_company.text = item.company
        containerView.job_title.text = item.title
        containerView.job_location.text = containerView.resources.getString(R.string.location) + ": " + item.location
        containerView.date_added.text = item.createdAt.toFormattedString("dd/MM - hh:mm a")
        containerView.job_type.text = item.type
        if (item.companyLogo.isNullOrEmpty()) {
            containerView.company_logo.setImageResource(R.drawable.ic_launcher_foreground)
        } else {
            Picasso.get().load(item.companyLogo).fit().centerCrop().into(containerView.company_logo)
        }
        containerView.setOnClickListener {
            onPress(item)
        }
    }

}