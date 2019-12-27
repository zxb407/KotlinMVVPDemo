package com.jjshouse.kotlinmvvpdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun jump(view: View){
        startActivity(Intent(this@MainActivity,SecondActivity::class.java))
    }
}
