package com.dgdgjfm.l.myapplication

class GraoceryRepostory(private  var dataBase: DataBase) {

   suspend fun  insert(items: GroceryItem)=dataBase.getGroceryData().insert(items)
    suspend fun delete(items: GroceryItem)=dataBase.getGroceryData().delete(items)

    fun  getAllItems()=dataBase.getGroceryData().getAllGroceryItem()
}