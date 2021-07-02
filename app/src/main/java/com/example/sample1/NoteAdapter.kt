package com.example.sample1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(val viewModel:MainiewModel,val arrayList: ArrayList<Blog>,val context:Context ):RecyclerView.Adapter<NoteAdapter.NotesViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {

        val root=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view,parent,false
            )
        return NotesViewHolder(root)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
       holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
     if (arrayList.size==0){
         Toast.makeText(context,"List Is empty",Toast.LENGTH_SHORT).show()

     }
        else{

     }
        return arrayList.size
    }
    inner  class NotesViewHolder(val binding: View):RecyclerView.ViewHolder(binding) {
        fun bind(blog: Blog){
            val m=binding.findViewById<TextView>(R.id.title)
            val b=binding.findViewById<ImageButton>(R.id.delete)
           m.text =blog.title
           b.setOnClickListener {
                viewModel.remove(blog)
                notifyItemRemoved(arrayList.indexOf(blog))
            }
        }
    }
}