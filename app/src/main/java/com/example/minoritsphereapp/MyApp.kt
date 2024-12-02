package com.example.minoritsphereapp

import android.app.Application
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.ktx.database

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Enable Firebase Realtime Database persistence
        Firebase.database.setPersistenceEnabled(true)
    }
}
