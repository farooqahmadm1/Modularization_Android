package com.farooq.core.utils.mapper

interface Mapper<in T, out R> {
    suspend operator fun invoke(input: T): R
}