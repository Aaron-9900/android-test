package com.example.testcivitatis.activities

import android.content.Intent
import android.os.Bundle
import android.text.Html

import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.testcivitatis.R
import com.example.testcivitatis.navigation.Navigator
import com.example.testcivitatis.repository.localtypes.JobPosting
import com.example.testcivitatis.utils.toFormattedString
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.job_posting_view_holder.view.*
import kotlinx.android.synthetic.main.job_posting_view_holder.view.company_logo
import kotlinx.android.synthetic.main.job_posting_view_holder.view.job_title
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class DetailActivity : AppCompatActivity() {
    private lateinit var posting: JobPosting
    private val navigator: Navigator by inject { parametersOf(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        posting = intent.getSerializableExtra("JOB_POSTING") as JobPosting
        bind()
    }

    private fun bind() {
        val mainView = findViewById<ConstraintLayout>(R.id.detail)
        if (posting.companyLogo.isNullOrEmpty()) {
            mainView.company_logo.setImageResource(R.drawable.ic_launcher_foreground)
        } else {
            Picasso.get().load(posting.companyLogo).fit().centerCrop().into(mainView.company_logo)
        }
        mainView.job_title.text = posting.title
        mainView.company_name.text = posting.company
        mainView.detail_location.text = mainView.resources.getString(R.string.location) + ": " + posting.location
        mainView.detail_date_added.text = posting.createdAt.toFormattedString("dd/MM - hh:mm a")
        mainView.detail_job_type.text = posting.type
        mainView.company_website.text = mainView.resources.getString(R.string.website) + ": " +posting.url
        mainView.company_website.setOnClickListener {
            navigator.goToWebView(posting.url)
        }
        mainView.job_description.text = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            Html.fromHtml(posting.description, Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(posting.description)
        }
    }
}