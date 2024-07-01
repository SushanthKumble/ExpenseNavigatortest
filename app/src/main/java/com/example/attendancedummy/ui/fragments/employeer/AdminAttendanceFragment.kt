package com.example.attendancedummy.ui.fragments.employeer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.attendancedummy.R
import com.example.attendancedummy.adapters.AttendanceAdapter
import com.example.attendancedummy.models.AttendanceData

class AdminAttendanceFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: AttendanceAdapter
    private lateinit var userList: MutableList<AttendanceData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_admin_attendance, container, false)

        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Initialize with placeholder data
        userList = mutableListOf(
            AttendanceData("Sushanth", "Marketing", "Logged In", "https://www.google.com/imgres?q=profile%20pictures&imgurl=https%3A%2F%2Fimages.ctfassets.net%2Fh6goo9gw1hh6%2F2sNZtFAWOdP1lmQ33VwRN3%2F24e953b920a9cd0ff2e1d587742a2472%2F1-intro-photo-final.jpg%3Fw%3D1200%26h%3D992%26fl%3Dprogressive%26q%3D70%26fm%3Djpg&imgrefurl=https%3A%2F%2Fwww.picmonkey.com%2Fblog%2Fcreate-the-best-profile-pic&docid=R6YihD6FdgssrM&tbnid=gIgCQ-hjxb6uFM&vet=12ahUKEwiM84nq04WHAxUFUGwGHWghC28QM3oECB0QAA..i&w=1200&h=992&hcb=2&ved=2ahUKEwiM84nq04WHAxUFUGwGHWghC28QM3oECB0QAA"),
            AttendanceData("Abhishek", "Marketing", "Logged In", "https://example.com/profile_picture2.jpg"),
            AttendanceData("John", "Marketing", "Logged In", "https://example.com/profile_picture2.jpg"),
            AttendanceData("leo das", "Marketing", "Logged In", "https://example.com/profile_picture2.jpg"),
            AttendanceData("Antony Doe", "Marketing", "Logged In", "https://example.com/profile_picture2.jpg"),
            AttendanceData("Deona crasta", "Marketing", "Logged In", "https://example.com/profile_picture2.jpg"),
            AttendanceData("Kiran Kumar", "Marketing", "Logged In", "https://example.com/profile_picture2.jpg"),
        )

        userAdapter = AttendanceAdapter(userList)
        recyclerView.adapter = userAdapter

        return view
    }
}
