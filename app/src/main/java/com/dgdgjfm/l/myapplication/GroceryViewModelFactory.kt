package com.dgdgjfm.l.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GroceryViewModelFactory( private  val repostory: GraoceryRepostory): ViewModelProvider.NewInstanceFactory() {


    override fun <T:ViewModel> create(modelClass: Class<T>):T{
        return GroceryViewModel(repostory) as T
    }
}