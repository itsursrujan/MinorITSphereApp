package com.example.minoritsphereapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlacementAdapter(private val placementList: List<Placement>) :
    RecyclerView.Adapter<PlacementAdapter.PlacementViewHolder>() {

    class PlacementViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val companyName: TextView = view.findViewById(R.id.companyName)
        val packageAmount: TextView = view.findViewById(R.id.packageAmount)
        val criteria: TextView = view.findViewById(R.id.criteria)
        val date: TextView = view.findViewById(R.id.date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacementViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_placement, parent, false)
        return PlacementViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlacementViewHolder, position: Int) {
        val placement = placementList[position]
        holder.companyName.text = placement.companyName
        holder.packageAmount.text = placement.packageAmount
        holder.criteria.text = placement.criteria
        holder.date.text = placement.date
    }

    override fun getItemCount(): Int = placementList.size
}
