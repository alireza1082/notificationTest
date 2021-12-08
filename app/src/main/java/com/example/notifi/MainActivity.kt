package com.example.notifi

import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import android.app.NotificationChannel
import android.graphics.BitmapFactory
import android.os.Build


class MainActivity: AppCompatActivity() {

    private val GROUP_KEY = "com.android.example"
    private val CHANNEL_ID: String = "CHANNEL_ID"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.notification_button)
        button.setOnClickListener { showNotification() }
    }

    private fun showNotification() {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = NotificationCompat.Builder(this , CHANNEL_ID)
            .setContentTitle("sender")
            .setContentText("send some text")
            .setSmallIcon(R.drawable.ic_notification)
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("Much longer text that cannot fit one line..."))
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setGroup(GROUP_KEY)
            .setGroupSummary(true)
            .setChannelId(CHANNEL_ID)
            .setCustomBigContentView()
            .setColor(resources.getColor(R.color.purple_200))

        val notif = NotificationCompat.Builder(this , CHANNEL_ID)
            .setContentTitle("receiver")
            .setContentText("re some text")
            .setSmallIcon(R.drawable.ic_notification)
            .setGroup(GROUP_KEY)
            .setGroupSummary(true)
            .setChannelId(CHANNEL_ID)
            .setColor(resources.getColor(R.color.purple_200))

        Log.d("alireza", " eeee")
        createNotificationChannel()
        notificationManager.notify(1 , notification.build())
        notificationManager.notify(2 , notif.build())
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

}