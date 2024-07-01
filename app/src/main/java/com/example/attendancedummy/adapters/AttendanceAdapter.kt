package com.example.attendancedummy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.attendancedummy.R
import com.example.attendancedummy.models.AttendanceData

class AttendanceAdapter(private val  userList: List<AttendanceData>):RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder>() {


    inner class AttendanceViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val profilePicture: ImageView = itemView.findViewById(R.id.profile_picture)
        val name: TextView = itemView.findViewById(R.id.name)
        val role: TextView = itemView.findViewById(R.id.role)
        val status: TextView = itemView.findViewById(R.id.status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttendanceViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.emp_item,parent,false)
        return AttendanceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: AttendanceViewHolder, position: Int) {
        val user = userList[position]
        holder.name.text = user.name
        holder.role.text = user.role
        holder.status.text = user.status


        // Load profile picture using Glide
        Glide.with(holder.profilePicture.context)
            .load(user.profilePictureUrl)
            .placeholder(R.drawable.man) // Optional placeholder image
            .error(R.drawable.man) // Optional error image
            .into(holder.profilePicture)
    }

}