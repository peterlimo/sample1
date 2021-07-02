package com.example.sample1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MainVewModelFactory :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom(MainiewModel::class.java))
       {
return MainiewModel() as T
       }


    throw IllegalArgumentException("UnknownViemodel")


}
}