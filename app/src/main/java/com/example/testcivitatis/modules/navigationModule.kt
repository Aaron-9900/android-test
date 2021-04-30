package com.example.testcivitatis.modules

import android.content.Context
import com.example.testcivitatis.navigation.Navigator
import com.example.testcivitatis.navigation.NavigatorImpl
import org.koin.dsl.module

val navigationModule = module {
    factory<Navigator> { (context: Context) -> NavigatorImpl(context) }
}