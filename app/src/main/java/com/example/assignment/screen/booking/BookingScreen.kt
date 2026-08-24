package com.example.assignment.screen.booking

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment.data.model.Destination
import com.example.assignment.data.model.UserActivity
import com.example.assignment.screen.booking.components.BookingCard
import com.example.assignment.screen.navigation.NavBar
import com.google.android.gms.maps.model.LatLng

@Composable
fun BookingScreen(
    onBookTicket: (UserActivity) -> Unit
) {
    var selectedActivity by remember { mutableStateOf(UserActivity.STUDY) }

    val destination = remember {
        listOf(
            Destination(
                "KL",
                "(Current)",
                LatLng(
                    3.1390,
                    101.6869
                )
            ),
            Destination("KL", "(Current)", LatLng(3.1390, 101.6869)),
            Destination("SIN", "(Singapore)", LatLng(1.3521, 103.8198)),
            Destination("TPE", "(Taipei)", LatLng(25.0330, 121.5654)),
            Destination("TYO", "(Tokyo)", LatLng(35.6762, 139.6503))
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "SELECT DESTINATION",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopStart)
                .statusBarsPadding()
                .padding(start = 24.dp, top = 16.dp)
        )

        BookingCard(
            selectedActivity = selectedActivity,
            destinations = destination,
            onActivitySelected = { activity -> selectedActivity = activity },
            onBookClick = { onBookTicket(selectedActivity) },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .statusBarsPadding()
                .padding(top = 16.dp, end = 24.dp)
                .width(300.dp)
        )

        NavBar(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}