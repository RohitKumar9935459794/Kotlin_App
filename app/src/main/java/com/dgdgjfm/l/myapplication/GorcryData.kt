package com.dgdgjfm.l.myapplication

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GorcryData {

    // specifying the grocery item
    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun  insert(item: GroceryItem)

    //deleting grocery item
    @Delete
    suspend fun delete(item: GroceryItem)

    //here reading the data
    @Query("SELECT*FROM grocery_Item")
     fun getAllGroceryItem(): LiveData<List<GroceryItem>>
}