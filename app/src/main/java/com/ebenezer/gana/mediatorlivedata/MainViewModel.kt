package com.ebenezer.gana.mediatorlivedata

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _firstPlayerScore = MutableLiveData<Float>(0f)

    private var _secondPlayerScore = MutableLiveData(0f)

    val currentScore = MediatorLiveData<Float>()

    init {
        currentScore.addSource(_firstPlayerScore) { value ->
            currentScore.value = value
        }

        currentScore.addSource(_secondPlayerScore) { value ->
            currentScore.value = value
        }
    }


    fun setFirstPlayerScore(score: Float) {
        _firstPlayerScore.value = score
    }

    fun setSecondPlayerScore(score: Float) {
        _secondPlayerScore.value = score
    }

}