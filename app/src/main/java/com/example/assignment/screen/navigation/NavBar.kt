package com.example.assignment.screen.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NavBar(modifier: Modifier = Modifier) {
    NavigationBar(modifier = modifier) {
        NavigationBarItem(selected = true, onClick = {}, icon = { Icon(Icons.Default.Place, "Map") }, label = { Text("Map") })
        NavigationBarItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.History, "History") }, label = { Text("History") })
        NavigationBarItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.Person, "Person") }, label = { Text("Person") })
        NavigationBarItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.Settings, "Settings") }, label = { Text("Settings") })
    }
}