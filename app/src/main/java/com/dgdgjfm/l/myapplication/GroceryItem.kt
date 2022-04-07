package com.dgdgjfm.l.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grocery_Item")
data class GroceryItem (

    @ColumnInfo(name = "Item_Name")
    var Item_Name :String,

     @ColumnInfo(name = "Item_Quantity")
     var Item_Quantity:Int,


      @ColumnInfo(name = "Item_Price")
      var Item_Price:Int,

    )
{
    @PrimaryKey(autoGenerate = true)
    var Id:Int?= null
}