package ads.mov.academia


import ads.mov.academia.ui.theme.AcademiaTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class PaginaInicial : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AcademiaTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PaginaInicial ({}, modifier = Modifier
                        .padding((innerPadding)))
                }
            }
        }
    }
}

@Composable
fun PaginaInicial(onIniciarClick: () -> Unit, modifier: Modifier) {
    Column (
        modifier = Modifier.fillMaxSize().statusBarsPadding().background(MaterialTheme.colorScheme.secondary),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
    {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(150.dp)
                .clip(CircleShape)
        )
        Text("Seu treino, suas regras.\n" +
                "\n" +
                "Monte listas personalizadas de exercícios, descubra novos desafios e mantenha tudo sob controle em um só lugar.\n",
            modifier = Modifier.padding(bottom = 30.dp, top = 40.dp, end = 30.dp, start = 30.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 16.sp)
        Button(onClick = onIniciarClick, modifier = Modifier.height(60.dp)
            .width(200.dp)
            .padding(top = 10.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = MaterialTheme.colorScheme.primary
            )) {
            Text("Iniciar", fontSize = 25.sp)
        }
    }
}


@Composable
fun Inicio(onIniciarClick: () -> Unit, modifier: Modifier) {
    PaginaInicial (onIniciarClick = onIniciarClick, modifier)
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun InicioPreview() {
    AcademiaTheme() {
        Inicio(onIniciarClick = { }, modifier = Modifier)
    }
}