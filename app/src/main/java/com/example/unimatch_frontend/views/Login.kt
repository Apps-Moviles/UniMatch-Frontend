package com.example.unimatch_frontend.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.unimatch_frontend.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Login(recordarPantalla: NavHostController) {

    Scaffold (
        modifier = Modifier.fillMaxSize()

    ) {
        principal(recordarPantalla)
    }
}

@Composable
fun principal(recordarPantalla: NavHostController) {

    var txtUsu by remember { mutableStateOf("") }
    var txtPas by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFC4A484))
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id= R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .width(250.dp)
                .padding(20.dp)
        )

        Text(text = "UniMatch Login",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color =  Color.Black)

        OutlinedTextField(
            value = txtUsu,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            label = { Text(text = "Usuario")},
            placeholder = { Text(text = "Ingrese Usuario")},
            onValueChange = { txtUsu = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = Color.Black
                )
            },

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        )

        OutlinedTextField(
            value = txtPas,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            label = { Text(text = "Contraseña")},
            placeholder = { Text(text = "Ingrese su Contraseña")},
            onValueChange = { txtPas = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    tint = Color.Black
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        )

        var isDisplay by remember { mutableStateOf(false) }

        if (isDisplay){
            Dialog(onDismissRequest = {isDisplay=false}) {
                Card ( modifier = Modifier
                    .height(300.dp),
                    shape = RoundedCornerShape(15.dp)
                ){
                    Column (modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally){

                        Text(text = "ERROR",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red)

                        Text(text = "Credenciales Incorrectas",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Blue)

                        Button(onClick = {isDisplay=false}) {
                            Text(text = "Vuelve a intentarlo",
                                fontSize = 25.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold)

                        }
                    }
                }


            }
        }



        ElevatedButton(
            modifier = Modifier
                    .fillMaxWidth()
                .padding(vertical = 30.dp),

            onClick = {
                if(txtUsu=="Admin" && txtPas=="1234"){

                    recordarPantalla.navigate("V2")
                } else{
                    isDisplay=true
                }

            }
        ) {
            Text(text = "Iniciar Sesión")
        }
    }

}
