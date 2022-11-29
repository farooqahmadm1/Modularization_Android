package com.farooq.rss.domain.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

data class Feed(
    val title: String,
    val description: String,
    val category: String,
    val image: String
)
