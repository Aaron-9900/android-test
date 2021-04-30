package com.example.testcivitatis.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.testcivitatis.R
import com.example.testcivitatis.repository.localtypes.JobPosting
import com.example.testcivitatis.viewholders.JobViewHolder


class JobAdapter(val onPress: (jobPosting: JobPosting) -> Unit): BaseAdapter<JobPosting, JobViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder  {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.job_posting_view_holder, parent, false)
        return JobViewHolder(view, onPress)
    }
}