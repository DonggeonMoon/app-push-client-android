package com.dgmoonlabs.app_push_client.service

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.Constants.TAG
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseMessagingServiceImpl : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "Refreshed token: $token")

        Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
        sendRegistrationToServer(token)
    }

    private fun sendRegistrationToServer(token: String) {
        TODO("Not yet implemented")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.d(TAG, "From: ${message.from}")

        if (message.data.isNotEmpty()) {
            Log.d(TAG, "Message data payload: ${message.data}")
        }

        message.notification?.let {
            Log.d(TAG, "Message Notification Title: ${it.title}")
            Log.d(TAG, "Message Notification Body: ${it.body}")
            Handler(Looper.getMainLooper()).post {
                Toast.makeText(
                    applicationContext,
                    "Message Notification Title: ${it.title}",
                    Toast.LENGTH_LONG
                ).show()
                Toast.makeText(
                    applicationContext,
                    "Message Notification Body: ${it.body}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}