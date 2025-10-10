package com.example.unimatch_frontend.views

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.unimatch_frontend.R
import com.example.unimatch_frontend.components.Card
import com.example.unimatch_frontend.components.Drawer
import com.example.unimatch_frontend.components.Status
import com.example.unimatch_frontend.components.StatusChip
import com.example.unimatch_frontend.components.TopBar
import com.example.unimatch_frontend.ui.theme.Blue40
import com.example.unimatch_frontend.ui.theme.Purple10
import com.example.unimatch_frontend.ui.theme.Purple40
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CompanyDescription(recordarPantalla: NavHostController) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val company = mapOf(
            "company" to "BioPafi",
            "puntuation" to "4.9",
            "owner" to "Alexander Davila",
            "location" to "Lima, Perú",
            "focus" to "Biotecnologia",
            "email" to "innovatetech-info@gmail.com",
            "phone" to "+51 944637126"
        )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Drawer(recordarPantalla)
            }
        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBar(
                    onOpenDrawer = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
            },
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color(0xFFC4A484))
                    .padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Image(
                    painter = painterResource(id= R.drawable.biopafi),
                    contentDescription = null,
                    modifier = Modifier
                        .size(250.dp)
                        .padding(20.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = company["company"]!!,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Default.Star, // estrella vacía
                        contentDescription = "Estrella vacía",
                        modifier = Modifier.size(28.dp)
                    )
                    Text(company["puntuation"]!!)
                }
                Spacer(modifier = Modifier.height(24.dp))

                Row {
                    Text(text = "Encargado: ", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = company["owner"]!!, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                }
                Row {
                    Text(text = "Ciudad/Pais: ", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = company["location"]!!, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                }
                Row {
                    Text(text = "Enfoque: ", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = company["focus"]!!, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                }
                Row {
                    Text(text = "Email: ", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = company["email"]!!, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                }
                Row {
                    Text(text = "Celular: ", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = company["phone"]!!, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                }
                Spacer(modifier = Modifier.height(100.dp))

                Button(
                    onClick = {
                        recordarPantalla.navigate("company/0/reviews")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFFACD),
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                ) {
                    Text(text = "Ver Reseñas", fontSize = 15.sp)
                }
            }
        }
    }
}
