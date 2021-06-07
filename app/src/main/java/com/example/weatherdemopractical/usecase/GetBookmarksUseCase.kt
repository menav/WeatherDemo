package com.example.weatherdemopractical.usecase

import com.example.weatherdemopractical.core.database.dao.BookmarkDao

class GetBookmarksUseCase(private val dao: BookmarkDao) {

    suspend fun execute() = dao.getAll()
}
