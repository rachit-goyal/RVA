package com.learn.rva.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learn.rva.data.model.Model
import com.learn.rva.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
created by Rachit on 2/27/2024.
 */

@HiltViewModel
class MainViewModel @Inject constructor(val repository: MainRepository) : ViewModel() {


    val _isValid = MutableLiveData<Boolean>()
    val IsDateValid: LiveData<Boolean> = _isValid



    fun validateBirthDate(model: Model) {

        viewModelScope.launch {
            val age=repository.isValidUser(model)
            _isValid.value = age in 18..70
        }

    }
}