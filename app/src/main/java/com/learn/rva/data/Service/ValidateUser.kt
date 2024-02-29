package com.learn.rva.data.Service

import com.learn.rva.data.model.Model
import kotlinx.coroutines.delay
import java.util.Calendar

/**
created by Rachit on 2/27/2024.
 */
class ValidateUser {


    suspend fun validateBirthDate(model: Model): Int {

        delay(500)
        val c1 = Calendar.getInstance()
        c1[model.year, model.month - 1, model.day, 0] = 0
        val c2 = Calendar.getInstance()
        var diff = c2[Calendar.YEAR] - c1[Calendar.YEAR]
        if (c1[Calendar.MONTH] > c2[Calendar.MONTH] ||
            c1[Calendar.MONTH] == c2[Calendar.MONTH] && c1[Calendar.DATE] > c2[Calendar.DATE]
        ) {
            diff--
        }

        return diff
    }
}