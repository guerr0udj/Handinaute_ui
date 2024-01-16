package com.example.handinaute

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

public class MyDialogViewModel : ViewModel() {

    private var _isDialogOpen = mutableStateOf(false)
    //val isDialogOpen: LiveData<Boolean> get() = _isDialogOpen
    val isDialogOpen: Boolean get() = _isDialogOpen.value


    fun onShowDialog(){
        _isDialogOpen.value = true
    }

    fun onDiscardDialog(){
        _isDialogOpen.value = false
    }

}