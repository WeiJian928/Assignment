package com.example.assignment.screen.booking.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment.data.model.Destination
import com.example.assignment.data.model.UserActivity
import com.example.assignment.screen.booking.components.SelectButton

@Composable
fun BookingCard(
    selectedActivity: UserActivity,
    destinations: List<Destination>,
    onActivitySelected: (UserActivity) -> Unit,
    onBookClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text("Booking: KL to Singapore", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(110.dp)
                        .background(Color(0xFFE0E0E0), RoundedCornerShape(6.dp))
                ) {
                    MapView(destinations = destinations)
                }

                Column(modifier = Modifier.weight(1f)) {
                    Text("Activity", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                    UserActivity.entries.forEach { activity ->
                        SelectButton(
                            text = activity.label,
                            isSelected = selectedActivity == activity,
                            onClick = { onActivitySelected(activity) }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onBookClick,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD3D3D3)),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Text("[ Book Ticket ]", color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }
    }
}
