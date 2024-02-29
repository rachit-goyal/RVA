package com.learn.rva.domain.repository

import com.learn.rva.data.model.Model

/**
created by Rachit on 2/27/2024.
 */
interface MainRepository {

    suspend fun isValidUser(model: Model): Int
}