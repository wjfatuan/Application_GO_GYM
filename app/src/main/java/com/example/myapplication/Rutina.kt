package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.border
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class Rutina : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RutinaScreen()
        }
    }
}


@Composable
fun RutinaScreen() {
    val context = LocalContext.current


    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "INCLINE PRESS", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.inclinado),
            contentDescription = "Press en Banco Inclinado",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "6/8 X 3", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Ajusta el banco a 30-45°, aprieta omóplatos, baja controlado y empuja con fuerza.",
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        TablaRutina()
        Spacer(modifier = Modifier.height(32.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
            ) {
                Text(text = "terminar rutina", fontSize = 28.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}


@Composable
fun TablaRutina() {
    Column(modifier = Modifier.fillMaxWidth().border(BorderStroke(4.dp, Color.Black))) {
        TableRow("Serie", "Reps", "Rest", "Peso", isHeader = true)
        TableRow("1", "8", "2", "65 kg")
        TableRow("2", "8", "2", "70 kg")
        TableRow("3", "6", "2", "60 kg")
    }
}


@Composable
fun TableRow(col1: String, col2: String, col3: String, col4: String, isHeader: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(BorderStroke(2.dp, Color.Black))
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = col1, modifier = Modifier.weight(1f), fontSize = 24.sp, fontWeight = if (isHeader) FontWeight.Bold else FontWeight.Normal)
        Text(text = col2, modifier = Modifier.weight(1f), fontSize = 24.sp, fontWeight = if (isHeader) FontWeight.Bold else FontWeight.Normal)
        Text(text = col3, modifier = Modifier.weight(1f), fontSize = 24.sp, fontWeight = if (isHeader) FontWeight.Bold else FontWeight.Normal)
        Text(text = col4, modifier = Modifier.weight(1f), fontSize = 24.sp, fontWeight = if (isHeader) FontWeight.Bold else FontWeight.Normal)
    }
}


@Preview(showBackground = true)
@Composable
fun RutinaPreview() {
    RutinaScreen()
}
