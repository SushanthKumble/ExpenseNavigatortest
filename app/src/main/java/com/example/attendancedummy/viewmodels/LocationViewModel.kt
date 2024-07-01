package com.example.attendancedummy.viewmodels

import android.Manifest
import android.app.Application
import android.content.pm.PackageManager
import android.location.Geocoder
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.util.*

class LocationViewModel(application: Application) : AndroidViewModel(application) {

    private val fusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(application)

    private val _location = MutableLiveData<String>()
    val location: LiveData<String> get() = _location

    init {
        fetchLocation()
    }

    fun fetchLocation() {
        if (ContextCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ContextCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Permissions are not granted
            _location.postValue("Permissions not granted")
            return
        }

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                val geocoder = Geocoder(getApplication(), Locale.getDefault())
                val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)
                if (addresses != null) {
                    if (addresses.isNotEmpty()) {
                        val address = addresses[0]
                        _location.postValue(address.locality ?: "Location not found")
                    } else {
                        _location.postValue("Location not found")
                    }
                }
            } else {
                _location.postValue("Unable to get location")
            }
        }
    }
}
