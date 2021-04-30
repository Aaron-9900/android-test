package com.example.testcivitatis.utils

import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

object DateUtils {
    fun DateFromNow(days: Int): Date {
        var date = Date()
        return Date(date.time - days * 24 * 60 * 60 * 1000)
    }
}

fun Date.toFormattedString(format: String): String {
    val dateFormat = SimpleDateFormat(format)
    return dateFormat.format(this)
}
fun String.toFormattedDate(format: String): Date {
    val dateFormat = SimpleDateFormat(format)
    return dateFormat.parse(this)
}