package com.farooq.rss.data.remote.dto

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(name = "rss", strict = false)
data class StoriesDto @JvmOverloads constructor(
    @field:Element(name = "channel", required = false)
    @param:Element(name = "channel", required = false)
    var channel: ChannelDto? = null
) {

    @Root(name = "channel", strict = false)
    data class ChannelDto @JvmOverloads constructor(
        @field:Element(name = "title", required = false)
        @param:Element(name = "title", required = false)
        val title: String,

        @field:Element(name = "link", required = false)
        @param:Element(name = "link", required = false)
        val link: String,

        @field:Element(name = "description", required = false)
        @param:Element(name = "description", required = false)
        val description: String,

        @field:Element(name = "copyright", required = false)
        @param:Element(name = "copyright", required = false)
        val copyright: String,


        @get:ElementList(name = "item", inline = true, required = false)
        @param:ElementList(name = "item", inline = true, required = false)
        val item: List<ItemDto>? = null,
    ) {
        @Root(name = "item", strict = false)
        data class ItemDto @JvmOverloads constructor(

            @field:Element(name = "title", required = false)
            @param:Element(name = "title", required = false)
            val title: String? = null,

            @field:Element(name = "link", required = false)
            @param:Element(name = "link", required = false)
            val link: String? = null,

            @field:Element(name = "content", required = false)
            @param:Element(name = "content", required = false)
            val content: String? = null,

            @field:Element(name = "description", required = false)
            @param:Element(name = "description", required = false)
            val description: String? = null,

            @field:Element(name = "category", required = false)
            @param:Element(name = "category", required = false)
            val category: String? = null,

            @field:Element(name = "guid", required = false)
            @param:Element(name = "guid", required = false)
            val guid: String? = null,

            @field:Element(name = "pubDate", required = false)
            @param:Element(name = "pubDate", required = false)
            val pubDate: String? = null,
        )
    }
}
