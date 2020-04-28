package com.codepath.jmckinley.savvyfirebasereboot.FirebaseCloudMessaging

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.util.Log
import com.codepath.jmckinley.savvyfirebasereboot.activities.MessageChatActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService(){

    val TAG = "MyFirebaseMessagingService"

    @SuppressLint("LongLogTag")
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d (TAG, "From: " + remoteMessage!!.from)
        Log.d(TAG, "Notification message body: " + remoteMessage.notification?.body!!)

        val intent = Intent(this@MyFirebaseMessagingService, MessageChatActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.putExtra("message", remoteMessage.notification?.body!!)
        startActivity(intent)
    }

}