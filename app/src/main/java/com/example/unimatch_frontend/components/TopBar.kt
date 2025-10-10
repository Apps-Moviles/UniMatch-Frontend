package com.example.unimatch_frontend.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onOpenDrawer:()->Unit
){

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = { Text(text = "UniMatch") },

        navigationIcon = {
            IconButton(onClick = {
                onOpenDrawer()

            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
        },

        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null
                )
            }

            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            }

            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = null
                )
            }
        }
    )
}