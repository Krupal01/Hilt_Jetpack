package com.example.hilt_jetpack.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavViewModel @Inject constructor() : ViewModel() {

    var scr2Data = MutableLiveData<String>("")


}