package com.example.assignment.screen.booking.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.assignment.data.model.Destination
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.GoogleMap

@Composable
fun MapView(
    destinations: List<Destination>,
    modifier: Modifier = Modifier
) {
    val cameraState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(15.0, 120.0), 3f)
    }

    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraState,
        uiSettings = MapUiSettings(zoomControlsEnabled = false)
    ) {
        destinations.forEach { location ->
            Marker(
                state = MarkerState(position = location.position),
                title = location.title,
                snippet = location.subtitle
            )
        }
    }
}