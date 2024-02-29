package com.learn.rva.data.repository

import com.learn.rva.data.Service.ValidateUser
import com.learn.rva.data.model.Model
import com.learn.rva.domain.repository.MainRepository
import javax.inject.Inject

/**
created by Rachit on 2/27/2024.
 */
class RepositoryImpl @Inject constructor(val validateUser: ValidateUser):MainRepository {



    override suspend fun isValidUser(model: Model): Int {
        return validateUser.validateBirthDate(model)
    }
}