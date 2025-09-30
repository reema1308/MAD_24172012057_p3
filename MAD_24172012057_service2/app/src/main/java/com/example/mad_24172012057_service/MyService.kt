package com.example.mad_24172012057_service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MyService : Service() {
    lateinit var mediaPlayer: MediaPlayer
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(!this::mediaPlayer.isInitialized){
            mediaPlayer= MediaPlayer.create(this,R.raw.song)
        }
        if(intent!=null){
            val strData=intent.getStringExtra("ServiceData")
            if(strData=="PlayPause"){
                if(!mediaPlayer.isPlaying)
                    mediaPlayer.start()
                else
                    mediaPlayer.pause()
            }
        }
        else{
            mediaPlayer.start()
        }
        return START_STICKY
    }
}