package com.dgdgjfm.l.myapplication

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
      //  val factory= GroceryViewModelFactory(graoceryRepostory)
      //  graoceryViewModel= ViewModelProvider(this,factory) .get(GroceryViewModel::class.java)
        graoceryViewModel.getAllGroceryItems().observe(this, Observer {
            groceryByAdpter.list = it

            groceryByAdpter.notifyDataSetChanged()

        })
        add_btn.setOnClickListener(){

        }
        fun  openDylog(){
            val dialog=Dialog(this)
            dialog.setContentView(R.layout.grocery_add_dilog)
            val cancle_btn = dialog.findViewById<Button>(R.id.idBtnCancle)
            val add_btn= dialog.findViewById<Button>(R.id.idBtnAdd)
            val ItemEdt= dialog.findViewById<EditText>(R.id.idEditItemName)
            val ItemQty= dialog.findViewById<EditText>(R.id.idEditItemQuantity)
            val ItemPrice= dialog.findViewById<EditText>(R.id.idEditItemPrice)
            cancle_btn.setOnClickListener{
                dialog.dismiss()
            }

            add_btn.setOnClickListener{
                val itemName:String= ItemEdt.text.toString()
                val itemQuantity:String= ItemQty.text.toString()
                val itemPrice:String= ItemPrice.text.toString()

                val qty:Int=itemQuantity.toInt()
                val price:Int = itemPrice.toInt()
                if (itemName.isNotEmpty() && itemPrice.isNotEmpty() && itemQuantity.isNotEmpty()) {
                    val item = GroceryItem(itemName, qty, price)
                    graoceryViewModel.insert(item)
                    Toast.makeText(applicationContext, "Item inserted", Toast.LENGTH_SHORT).show()
                    groceryByAdpter.notifyDataSetChanged()
                    dialog.dismiss()
                }else{
                    Toast.makeText(applicationContext, "Please enter all the data", Toast.LENGTH_SHORT).show()
                }

            }
            dialog.show()

        }

        fun onItemClick(groceryItem: GroceryItem) {
          graoceryViewModel.delete(groceryItem)
          //  graoceryViewModel.notifyDataSetChanged()
            Toast.makeText(applicationContext,"Item deleted",Toast.LENGTH_SHORT).show()
        }
    }
}