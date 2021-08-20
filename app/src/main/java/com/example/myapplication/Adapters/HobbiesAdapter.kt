package com.example.myapplication.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Hobby
import com.example.myapplication.R
import com.example.myapplication.showToast


class HobbiesAdapter(private val context: Context, private val hobbies: List<Hobby>): RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby= hobbies[position]
        holder.txvTitle.text = hobby.title
        holder.setData(hobby, position)
    }

    override fun getItemCount(): Int {
        return hobbies.size

    }
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var currentHobby: Hobby?=null
        private var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                currentHobby?.let {
                    context.showToast(currentHobby!!.title+"Clicked")
                }

            }
            itemView.setOnClickListener {
                currentHobby?.let {
                    val message: String = "My hobby is: "+ currentHobby!!.title
                    val intent = Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type = "plain/text"

                    context.startActivity(Intent.createChooser(intent, "share to: "))
                }
            }
        }
        val txvTitle: TextView = itemView.findViewById(R.id.txvTitle)
        fun setData (hobby: Hobby, pos: Int){
            this.currentHobby =  hobby
            this. currentPosition = pos
        }

    }
}