package com.example.mad_24172012057_p3

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.buttonCallLog).setOnClickListener {
            Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:"+findViewById<EditText>(R.id.editTextPhone).text.toString())).also {startActivity( it )}
        }

        // Open specific URL
        findViewById<Button>(R.id.buttonLoad).setOnClickListener {
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://"+findViewById<EditText>(R.id.editTextUrl).text.toString())).also { startActivity(it) }
        }

        // Open Call Log
        findViewById<Button>(R.id.buttonCallLog).setOnClickListener {
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("content://call_log/calls")).also { startActivity(it) }
        }

        // Open Gallery
        findViewById<Button>(R.id.buttonGallery).setOnClickListener {
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("content://media/internal/images/media")
            ).also { startActivity(it) }
        }

        // Set Alarm
        findViewById<Button>(R.id.buttonAlarm).setOnClickListener {
            val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_HOUR, 9)
                putExtra(AlarmClock.EXTRA_MINUTES, 0)
                putExtra(AlarmClock.EXTRA_MESSAGE, "Wake up!")
            }
            startActivity(intent)
        }

        // Open Camera
        findViewById<Button>(R.id.buttonCamera).setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        // Open Login Activity
        findViewById<Button>(R.id.buttonLogin).setOnClickListener {
            Intent(this, LoginActivity::class.java).also { startActivity( it ) }
        }

    }
}
