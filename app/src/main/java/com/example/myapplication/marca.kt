package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

class marca : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            marcaScreen()
        }
    }
}

@Composable
fun marcaScreen() {
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "TU HISTORIAL",
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            barChart()

            Spacer(modifier = Modifier.height(32.dp))


            Button(
                onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
            ) {
                Text(text = "Inicio", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun barChart() {
    val ejercicios = listOf("CURL BICEP", "BANCA", "SENTADILLA", "P.M")
    val alturasAzul = listOf(50, 100, 120, 180)
    val alturasCeleste = listOf(80, 120, 140, 200)
    val marcas = listOf(0, 50, 100, 150, 200)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            marcas.reversed().forEach { marca ->
                Text(
                    text = "$marca",
                    fontSize = 12.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Spacer(modifier = Modifier.height(40.dp))
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                marcas.forEach { _ ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.Gray.copy(alpha = 0.5f))
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.Bottom
            ) {
                ejercicios.forEachIndexed { index, ejercicio ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Row(
                            modifier = Modifier.height(alturasCeleste[index].dp),
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Box(
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(alturasAzul[index].dp)
                                    .background(Color.Blue, shape = RoundedCornerShape(4.dp))
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Box(
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(alturasCeleste[index].dp)
                                    .background(Color.Cyan, shape = RoundedCornerShape(4.dp))
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = ejercicio,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.width(70.dp)
                        )
                    }
                }
            }
        }
    }
}
