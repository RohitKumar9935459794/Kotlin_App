package com.dgdgjfm.l.myapplication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GroceryViewModel (private  val repostory: GraoceryRepostory):ViewModel(){

    fun insert(item: GroceryItem)=GlobalScope.launch {
        repostory.insert(item)
    }

    fun  delete(item: GroceryItem)=GlobalScope.launch {
        repostory.delete(item)
    }

    fun getAllGroceryItems()= repostory.getAllItems()
}