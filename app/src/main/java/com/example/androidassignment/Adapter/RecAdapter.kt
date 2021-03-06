package com.example.androidassignment.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidassignment.FourthTask
import com.example.androidassignment.R
import com.example.myloginapp.interfacePackage.OnClickListner

class RecAdapter(context: FourthTask, data: ArrayList<String>) :RecyclerView.Adapter<RecAdapter.ViewHolder>() {

    var context : Context = context
    var arr : ArrayList<String> = data
    var onclickItem : OnClickListner = context

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
       var textview : TextView = itemView.findViewById(R.id.txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.textview.text = arr.get(position)
        holder.textview.setOnClickListener(View.OnClickListener {
            onclickItem.onItemClick(position)
        })
    }

    override fun getItemCount(): Int {
       return arr.size
    }

}