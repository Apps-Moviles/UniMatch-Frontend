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
import com.example.unimatch_frontend.ui.theme.Blue40
import com.example.unimatch_frontend.ui.theme.Purple10
import com.example.unimatch_frontend.ui.theme.Purple40
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Oportunity(recordarPantalla: NavHostController, index: Int) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val oportunities = arrayOf(
        mapOf(
            "title" to "Front-End Design",
            "owner" to "BioPafi",
            "payment" to "$200",
            "description" to """Se busca personal para encargarse del diseño de nuestra nueva página web para nuestra empresa dedicada al desarrollo de soluciones tecnológicas. La página debe transmitir una imagen moderna, profesional y alineada con nuestros valores de innovación, confianza y excelencia.""",
            "statements" to """Se busca gente con experiencia previa en diseño web responsive.
Dominio de herramientas como Figma, Adobe XD o similares.
Conocimientos básicos de HTML/CSS son un plus.
Buen criterio visual y atención al detalle.""",
            "duration" to "De 2 a 3 semanas",
            "payment" to "200 dolares"
        ),
        mapOf(
            "title" to "Backend-developer",
            "owner" to "BioPafi",
            "payment" to "$150",
            "description" to """Se busca personal para encargarse del diseño de nuestra nueva página web para nuestra empresa dedicada al desarrollo de soluciones tecnológicas. La página debe transmitir una imagen moderna, profesional y alineada con nuestros valores de innovación, confianza y excelencia.""",
            "statements" to """Se busca gente con experiencia previa en diseño web responsive.
Dominio de herramientas como Figma, Adobe XD o similares.
Conocimientos básicos de HTML/CSS son un plus.
Buen criterio visual y atención al detalle.""",

            "duration" to "De 2 a 3 semanas",
            "payment" to "200 dolares"
        ),
    )

    val oportunity = oportunities[index]

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
                    text = oportunity["title"]!!,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "By " + oportunity["owner"]!!,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 22.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(24.dp))


                Column(
                    verticalArrangement = Arrangement.Top,
                ) {
                    Text(text = "Desscripcion:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = oportunity["description"]!!, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(24.dp))

                    Text(text = "Requisitos:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = oportunity["statements"]!!, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(24.dp))

                    Text(text = "Duracion:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = oportunity["duration"]!!, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(24.dp))

                    Text(text = "Pago:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = oportunity["payment"]!!, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                }
                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Button(
                        onClick = {
                            recordarPantalla.navigate("Company/0")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Purple10,
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                    ) {
                        Text(text = "Ver Empresa", fontSize = 15.sp)
                    }
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFFACD),
                            contentColor = Color.Black
                        ),
                        modifier = Modifier
                    ) {
                        Text(text = "Postularme", fontSize = 15.sp)
                    }
                }
            }
        }
    }
}
