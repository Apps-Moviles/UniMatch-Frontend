package com.example.unimatch_frontend.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.unimatch_frontend.R

@Composable

fun Drawer(recordarPantalla: NavHostController){

    Box(
        modifier = Modifier
            .height(180.dp)
            .width(200.dp)
            .padding(20.dp)
    ){
        Image(
            painter = painterResource(id= R.drawable.user),
            contentDescription = null,
            modifier = Modifier
                .size(180.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray,CircleShape)
        )
    }

    Text(
        text = "UniMatch",
        fontSize = 25.sp,
        modifier = Modifier
            .padding(15.dp)
    )

    Spacer(modifier = Modifier.height(10.dp))
    HorizontalDivider()
    Spacer(modifier = Modifier.height(10.dp))

    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = null
            )
        },

        label = {
            Text(
                text = "Postulaciones",
                fontSize = 20.sp,
                modifier = Modifier.padding(15.dp)
            )
        },
        selected = false,
        onClick = {
            recordarPantalla.navigate("V2")
        }
    )
    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null
            )
        },

        label = {
            Text(
                text = "Oportunidades",
                fontSize = 20.sp,
                modifier = Modifier.padding(15.dp)
            )
        },
        selected = false,
        onClick = {
            recordarPantalla.navigate("Opportunities")
        }
    )
    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = null
            )
        },

        label = {
            Text(
                text = "Portfolio",
                fontSize = 20.sp,
                modifier = Modifier.padding(15.dp)
            )
        },
        selected = false,
        onClick = {
            recordarPantalla.navigate("Portfolio")
        }
    )
    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = null
            )
        },

        label = {
            Text(
                text = "Cuenta",
                fontSize = 20.sp,
                modifier = Modifier.padding(15.dp)
            )
        },
        selected = false,
        onClick = {  }
    )

    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null
            )
        },

        label = {
            Text(
                text = "Notificaciones",
                fontSize = 20.sp,
                modifier = Modifier.padding(15.dp)
            )
        },
        selected = false,
        onClick = {  }
    )

    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Default.ExitToApp,
                contentDescription = null
            )
        },

        label = {
            Text(
                text = "Salir",
                fontSize = 20.sp,
                modifier = Modifier.padding(15.dp)
            )
        },
        selected = false,
        onClick = { recordarPantalla.popBackStack() }
    )
}