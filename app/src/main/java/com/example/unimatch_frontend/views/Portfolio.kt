package com.example.unimatch_frontend.views

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.unimatch_frontend.components.Card
import com.example.unimatch_frontend.components.Drawer
import com.example.unimatch_frontend.components.Status
import com.example.unimatch_frontend.components.StatusChip
import com.example.unimatch_frontend.components.TopBar
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Portfolio(recordarPantalla: NavHostController) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val portfolios = arrayOf(
        mapOf(
            "title" to "Front-End Design",
            "owner" to "BioPafi",
        ),
        mapOf(
            "title" to "Backend-developer",
            "owner" to "Zoren",
        ),
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
                Text(
                    text = "Portfolio",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(24.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                ) {
                    portfolios.forEachIndexed { index, pf ->
                        Card(
                            modifier = Modifier
                                .padding(vertical = 10.dp),
                            onClick = {
                                recordarPantalla.navigate("Portfolio/${index}")
                            }
                        ) {
                            Column(

                            ) {
                                Text(text = pf["title"]!!)

                                Spacer(modifier = Modifier
                                    .height(15.dp))
                                Text(text = "By " + pf["owner"]!!, fontSize = 14.sp)
                                Text(text = "Finalizado hace 1 semana", fontSize = 12.sp)

                                Row (
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}
