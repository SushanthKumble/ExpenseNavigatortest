package com.example.attendancedummy.ui.fragments.employee

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.attendancedummy.R

class Product:Fragment(R.layout.products_fragment) {

    private  lateinit var pagetitle:TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        pagetitle=view.findViewById(R.id.page_name)
        pagetitle.text="Products"
    }
}