package com.example.unimatch_frontend.views

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun PortfolioProyect(recordarPantalla: NavHostController, index: Int) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val portfolios = arrayOf(
        mapOf(
            "title" to "Front-End Design",
            "owner" to "BioPafi",
            "description" to "Se busca personal para encargarse del diseño de nuestra nueva página web para nuestra empresa dedicada al desarrollo de soluciones tecnológicas. La página debe transmitir una imagen moderna, profesional y alineada con nuestros valores de innovación, confianza y excelencia."
        ),
        mapOf(
            "title" to "Backend-developer",
            "owner" to "Zoren",
            "description" to "Descripción: Se busca personal para encargarse del diseño de nuestra nueva página web para nuestra empresa dedicada al desarrollo de soluciones tecnológicas. La página debe transmitir una imagen moderna, profesional y alineada con nuestros valores de innovación, confianza y excelencia."
        ),
    )

    val portfolio = portfolios[index]

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
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = portfolio["title"]!!,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "By " + portfolio["owner"]!!,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFFFACD),
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = "Descargar Certificado")
                }
                Spacer(modifier = Modifier.height(34.dp))

                Text(text = "Descripcion:", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                Text(text = portfolio["description"]!!, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
                Spacer(modifier = Modifier.height(34.dp))

                Text(text = "Dejar una reseña", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                Card(
                    modifier = Modifier
                        .padding(vertical = 18.dp)
                ) {
                    Text("")
                    Text("")
                    Text("")
                    Text("")
                }
                Text(text = "Deja una calificacíon", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)

                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        repeat(5) {
                            Icon(
                                imageVector = Icons.Default.Star, // estrella vacía
                                contentDescription = "Estrella vacía",
                                modifier = Modifier.size(28.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFFACD),
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                            .align(Alignment.End)
                    ) {
                        Text(text = "Enviar")
                    }
                }
            }
        }
    }
}
