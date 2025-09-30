package com.example.mad_24172012057_p4

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class AlarmService : Service() {

    lateinit var mediaPlayer: MediaPlayer
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(!this::mediaPlayer.isInitialized){
            mediaPlayer = MediaPlayer.create(this,R.raw.alarm)
        }
        if(intent!=null){
            val strData = intent.getStringExtra("ServiceData")
            mediaPlayer.start()
        }
        return START_STICKY
    }
    override fun onDestroy() {
        mediaPlayer.stop()
        super.onDestroy()
    }
}