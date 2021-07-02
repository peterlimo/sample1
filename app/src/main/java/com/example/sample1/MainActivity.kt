package com.example.sample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private var viewManager=LinearLayoutManager(this)
    private lateinit var viewmodel:MainiewModel
    lateinit var mainrecycler:RecyclerView
    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainrecycler=findViewById(R.id.recycler)
        val application= requireNotNull(this).application
        val factory=MainVewModelFactory()
        viewmodel=ViewModelProviders.of(this,factory).get(MainiewModel::class.java)
        btn=findViewById(R.id.button)

        btn.setOnClickListener(View.OnClickListener {
            addData()
        })
        initialiseAdapter()
    }

    private fun initialiseAdapter() {
       mainrecycler.layoutManager=viewManager
        observeData()
    }


    private fun observeData() {
       viewmodel.lst.observe(this, Observer {
           mainrecycler.adapter=NoteAdapter(
               viewmodel,it,this
           )
       })
    }

    private fun addData() {
        var txtplce = findViewById<EditText>(R.id.titletxt)
        var title=txtplce.text.toString()
        if(title.isNullOrBlank()){
            Toast.makeText(this,"Enter value!",Toast.LENGTH_LONG).show()
        }else{
            var blog= Blog(title)
            viewmodel.add(blog)
            txtplce.text.clear()
            mainrecycler.adapter?.notifyDataSetChanged()
        }

    }
    }
