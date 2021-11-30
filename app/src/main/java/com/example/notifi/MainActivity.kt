package com.example.notifi

import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.NotificationCompat

class MainActivity: AppCompatActivity() {

    private val GROUP_KEY = "com.android.example"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.notification_button)
        button.setOnClickListener { showNotification() }
    }

    private fun showNotification() {
//        val CHANNEL_ID: String = "CHANNEL_ID"
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        val notification = NotificationCompat.Builder(this)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("sender")
            .setContentText("send some text")
//            .setLargeIcon(R.drawable.ic_person)
            .setGroup(GROUP_KEY)
            .setColor(resources.getColor(R.color.purple_200))
            .build()

        Log.d("alireza", " eeee")
        notificationManager.notify(1 , notification)
    }
}