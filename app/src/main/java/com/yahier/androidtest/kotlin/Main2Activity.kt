package com.yahier.androidtest.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.yahier.androidtest.R
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        init()
    }

    fun init(){
        val fab = findViewById(R.id.tv1) as TextView
        fab.setOnClickListener {
            Toast.makeText(this,"show",Toast.LENGTH_SHORT).show()
        }

        tv1.setText("Hi!")
    }

}
