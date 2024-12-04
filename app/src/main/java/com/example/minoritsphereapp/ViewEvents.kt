package com.example.minoritsphereapp

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewEvents : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EventAdapter
    private val eventList = mutableListOf<Event>()

    private val CHANNEL_ID = "event_notifications"
    private val NOTIFICATION_ID = 102

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_events)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = EventAdapter(eventList)
        recyclerView.adapter = adapter

        // Create Notification Channel
        createNotificationChannel()

        // Load events from Firebase
        loadEventsFromFirebase()
    }

    private fun loadEventsFromFirebase() {
        val database = Firebase.database
        val eventsRef = database.getReference("events")

        // Listen for new events
        eventsRef.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val event = snapshot.getValue(Event::class.java)
                event?.let {
                    eventList.add(it)
                    adapter.notifyItemInserted(eventList.size - 1)
                    sendNotification("New Event Added", "${it.eventName} is now available. Check it out!")
                }
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                // Handle updates to events if needed
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                // Handle event removal if needed
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                // Handle event reordering if needed
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ViewEvents, "Failed to load events: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Event Notifications"
            val descriptionText = "Notifications for new events"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification(title: String, message: String) {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification) // Add your notification icon here
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            if (ActivityCompat.checkSelfPermission(
                    this@ViewEvents,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // Request permission if not granted
                ActivityCompat.requestPermissions(
                    this@ViewEvents,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    1
                )
                return
            }
            notify(NOTIFICATION_ID, builder.build())
        }
    }
}
