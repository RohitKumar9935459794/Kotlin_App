package com.dgdgjfm.l.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), GroceryByAdpter.GroceryItemClickInterface {
    lateinit var item_by:RecyclerView
    lateinit var add_btn:FloatingActionButton
    lateinit var list: List<GroceryItem>
    lateinit var groceryByAdpter: GroceryByAdpter
    lateinit var graoceryViewModel: GroceryViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // here inalizing
        item_by=findViewById(R.id.idViewItems)
        add_btn=findViewById(R.id.floating_bottum)
        list=ArrayList<GroceryItem>()
        groceryByAdpter= GroceryByAdpter(list,this)

        item_by.layoutManager= LinearLayoutManager(this)
        item_by.adapter=groceryByAdpter
        //val graoceryRepostory=GraoceryRepostory(DataBase(this))
        //val factory= GroceryViewModelFactory(graoceryRepostory)
        graoceryViewModel
    }
}