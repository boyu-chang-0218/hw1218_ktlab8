package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {
    override fun onCreate() {
        super.onCreate()
        Thread( {
            try {
                Thread.sleep(5000)
                val intent = Intent( this@MyService, MainActivity2::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                this@MyService.startActivity(intent)
            }catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }).start()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}