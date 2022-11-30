package com.farooq.core.utils

import android.util.Patterns
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
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

fun String.encodeUrl(): String {
    return URLEncoder.encode(this, StandardCharsets.UTF_8.toString())
}