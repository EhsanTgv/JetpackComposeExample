package com.taghavi.jetpackcomposeexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.taghavi.jetpackcomposeexample.text.SimpleTextActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startSimpleTextExample(view: View) {
        startActivity(Intent(this, SimpleTextActivity::class.java))
    }
}