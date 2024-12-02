package com.example.minoritsphereapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class ViewPlacements : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PlacementAdapter
    private val placementList = mutableListOf<Placement>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_placements)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PlacementAdapter(placementList)
        recyclerView.adapter = adapter

        loadPlacementsFromFirebase()
    }

    private fun loadPlacementsFromFirebase() {
        val database = Firebase.database
        val placementRef = database.getReference("placements")

        placementRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                placementList.clear()
                for (placementSnapshot in snapshot.children) {
                    val placement = placementSnapshot.getValue(Placement::class.java)
                    placement?.let { placementList.add(it) }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ViewPlacements, "Failed to load placements: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
