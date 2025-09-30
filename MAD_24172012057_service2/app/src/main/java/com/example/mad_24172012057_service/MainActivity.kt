package com.example.mad_24172012057_service

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<FloatingActionButton>(R.id.Play).setOnClickListener {
            playpause()
        }
        findViewById<FloatingActionButton>(R.id.Stop).setOnClickListener {
            onStop()
        }
    }

    fun playpause() {
        Intent(applicationContext, MyService::class.java).putExtra("ServiceData", "PlayPause")
            .apply {
                startService(this)
            }
    }

    fun stop() {
        Intent(applicationContext, MyService::class.java).apply {
            stopService(this)
        }

    }
}
