package com.example.ejemplo1composeidgs904

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejemplo1ComposeIDGS904Theme {
                Tarjeta(tarjetas)
            }
        }
    }
}

private val tarjetas: List<PersonajesTarjeta> = listOf(
    PersonajesTarjeta("Goku", "Descripcion: El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla"),
    PersonajesTarjeta("Vegeta", "Descripcion: El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla"),
    PersonajesTarjeta("Bulma", "Descripcion: El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla"),
    PersonajesTarjeta("Celula", "Descripcion: El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla"),
    PersonajesTarjeta("Freezer", "Descripcion: El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla"),
    PersonajesTarjeta("Ginyu", "Descripcion: El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla"),
    PersonajesTarjeta("Gohan", "Descripcion: El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla"),
    PersonajesTarjeta("Picolo", "Descripcion: El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla"),
    PersonajesTarjeta("Zarbon", "Descripcion: El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla"),
    PersonajesTarjeta("Dodoria", "Descripcion: El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla"),
)

data class PersonajesTarjeta(val nombre:String, val descripcion: String)

@Composable
fun Tarjeta(personajes: List<PersonajesTarjeta>){
    LazyColumn {
        items(personajes){
            personaje -> MyPersonajes(personaje)
        }
    }
}

@Composable
fun MyPersonajes(personaje: PersonajesTarjeta){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(8.dp)
        ) {
            ImagenHeroe(personaje.nombre)
            Personajes(personaje)
        }
    }
}

@Composable
fun Personajes(personaje: PersonajesTarjeta){
    Column {
        Personaje(personaje.nombre, MaterialTheme.colorScheme.primary, MaterialTheme.typography.titleLarge)
        Personaje(personaje.descripcion, MaterialTheme.colorScheme.onBackground, MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun Personaje(name:String, color: Color, style: androidx.compose.ui.text.TextStyle){
        Text(text = name)
}

@Composable
fun ImagenHeroe(imagenHeroe:String){
    val context = LocalContext.current
    val ImageResId = remember(imagenHeroe) {
        context.resources.getIdentifier(imagenHeroe.lowercase(),
            "drawable", context.packageName)
    }
    Image(
        painterResource(id=ImageResId),
        contentDescription = imagenHeroe,
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Preview
@Composable
fun previewCard(){
    Tarjeta(tarjetas)
}
