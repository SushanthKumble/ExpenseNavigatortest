package com.example.attendancedummy.ui.fragments.employee

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.attendancedummy.R
import com.example.attendancedummy.viewmodels.GreetingsViewModel
import com.example.attendancedummy.viewmodels.LocationViewModel


class Attendance : Fragment(R.layout.attendance_fragment) {

    private lateinit var locationTextView: TextView
    private  lateinit var pagetitle:TextView
    private  lateinit var greetingtext:TextView
    private val locationViewModel: LocationViewModel by viewModels()
    private val greetingViewModel: GreetingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pagetitle=view.findViewById(R.id.page_name)
        pagetitle.text="ATTENDANCE"
        locationTextView = view.findViewById(R.id.locatontext)
        greetingtext=view.findViewById(R.id.Geettextview)

        //gretting
        greetingViewModel.greeting.observe(viewLifecycleOwner, Observer { greeting ->
            greetingtext.text = greeting
        })




        // Observe location LiveData from ViewModel
        locationViewModel.location.observe(viewLifecycleOwner, Observer { location ->
            locationTextView.text = location
        })

        // Check and request location permissions
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Request permissions
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        } else {
            // Permissions already granted
            locationViewModel.fetchLocation()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                // Permission granted, fetch location
                locationViewModel.fetchLocation()
            } else {
                // Permission denied, show message
                locationTextView.text = "Permissions not granted"
            }
        }
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }
}
