package com.example.testcivitatis.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testcivitatis.R
import com.example.testcivitatis.adapters.JobAdapter
import com.example.testcivitatis.modules.*
import com.example.testcivitatis.navigation.Navigator
import com.example.testcivitatis.utils.DateUtils
import com.example.testcivitatis.viewmodels.MainActivityViewModel
import com.example.testcivitatis.viewmodels.ViewModelState
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf


class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModel()
    private val navigator: Navigator by inject { parametersOf(this) }
    private lateinit var viewAdapter: JobAdapter
    private val daysThreshold = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            modules(listOf(
                remoteDataSourceModule,
                apiModule,
                repositoryModule,
                viewModelModule,
                navigationModule)
            )
        }
        setContentView(R.layout.activity_main)
        bind()
        subscribe()
    }
    private fun bind() {
        val viewHolder: RecyclerView = findViewById(R.id.job_list)
        viewAdapter = JobAdapter {
            navigator.goToDetail(it)
        }
        viewHolder.adapter = viewAdapter
        viewHolder.layoutManager = LinearLayoutManager(this)
    }
    private fun subscribe() {
        val daysAgo = DateUtils.DateFromNow(daysThreshold)
        viewModel.status.observe(this, Observer {
            when(it) {
                ViewModelState.IDLE -> viewModel.fetchJobPostings()
                // Maybe handle spinner or errors
            }
        })
        viewModel.postings.observe(this, Observer {
            // Not sure why we would want to sort by ascending but so be it
            viewAdapter.items = it
                .filter{ !it.createdAt.before(daysAgo) }
                .sortedBy { it.createdAt }
                .toMutableList()
        })
    }
}