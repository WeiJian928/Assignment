package com.example.assignment.data.model

import com.google.android.gms.maps.model.LatLng

data class Destination(
    val title: String,
    val subtitle: String,
    val position: LatLng
)
