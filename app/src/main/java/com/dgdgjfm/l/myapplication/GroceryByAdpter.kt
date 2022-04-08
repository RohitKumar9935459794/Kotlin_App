package com.dgdgjfm.l.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class GroceryByAdpter(
    var  list: List<GroceryItem>,
    val  groceryItemClickInterface: GroceryItemClickInterface):
    RecyclerView.Adapter<GroceryByAdpter.GroceryViewHolder> (){


   inner class GroceryViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       val  nameTv= itemView.findViewById<TextView>(R.id.item_Name_text)
       val  quntatyTv= itemView.findViewById<TextView>(R.id.item_Quantity_text)
       val  rateTv= itemView.findViewById<TextView>(R.id.item_Rate_Text)
       val  amountTv= itemView.findViewById<TextView>(R.id.amount)
       val  deleteBtn= itemView.findViewById<TextView>(R.id.delete_image)

   }




    interface GroceryItemClickInterface{
        fun  onItemClick(groceryItem: GroceryItem) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
       val view= LayoutInflater.from(parent.context).inflate(R.layout.grocery_rb_item,parent,false)
        return GroceryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
       holder.nameTv.text= list.get(position).Item_Name
        holder.quntatyTv.text= list.get(position).Item_Quantity.toString()
        holder.rateTv.text= "Rs"+list.get(position).Item_Price.toString()
        val itemTotal:Int= list.get(position).Item_Price*list.get(position).Item_Price
        holder.amountTv.text= "Rs"+itemTotal.toString()
        holder.deleteBtn.setOnClickListener{
            groceryItemClickInterface.onItemClick(list.get(position))
        }

    }

    override fun getItemCount(): Int {
      return list.size
    }
}