package com.dgdgjfm.l.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [GroceryItem::class], version = 1)
abstract class DataBase: RoomDatabase() {

    abstract fun  getGroceryData(): GorcryData

    companion object{
        @Volatile
        private var instance: Database?= null
        private val  LOCK=Any()

        // here i am creating a invoke function
        operator  fun  invoke(context: Context)= instance?: synchronized(LOCK){
          //  instance?: CreateDatabase(context).also{
              //  instance=it
           // }
        }
    }

    private  fun CreateDatabase(context: Context)=
        Room.databaseBuilder(context.applicationContext,DataBase::class.java,"Grocery_db").build()

}