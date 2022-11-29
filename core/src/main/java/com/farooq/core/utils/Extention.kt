package com.farooq.core.utils

import android.util.Patterns
import java.util.regex.Matcher


fun String.extractUrl(): List<String> {
    val webMatcher: Matcher = Patterns.WEB_URL.matcher(this)
    val links: ArrayList<String> = ArrayList()

    while (webMatcher.find()) {
        try {
            links.add(webMatcher.group())
        } catch (e: Exception) {
        }
    }
    return links
}