package ads.mov.academia

import ads.mov.academia.ui.theme.AcademiaTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ListagemExercicios : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AcademiaTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListaExercicios(DataSource.Exercicios, modifier = Modifier.padding(innerPadding),
                        onCardClick = {}, onAddClick = {}, onReturnClick = {}, onViewListClick = {} , exerciciosSelecionados = emptyList(), comprimentoLista = 9)
                }
            }
        }
    }
}

//logotipo e fotos em cards
@Composable
fun Imagem(modifier: Modifier = Modifier, id: Int){
    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        modifier.clip(CircleShape)
    )
}

@Composable
fun CartaoExercicio(exercicio: Exercicio, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp).fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Imagem(Modifier.size(80.dp), exercicio.imagem  )
                LeftCard(exercicio = exercicio)
            }
        }
    }
}
//parte da esquerda dos cards (tanto pg principal quanto final)
@Composable
fun LeftCard(exercicio: Exercicio, modifier: Modifier = Modifier){
    Column(modifier = modifier
        .padding(10.dp)
        .fillMaxWidth()
        .padding(start = 8.dp)) {
        Text(
            exercicio.nome,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth()
        )
        Text(
            exercicio.descricao,
        )
    }
}


//botoes dos cards na pg principal
@Composable
fun ButtonsCard(modifier: Modifier = Modifier, adicionado: Boolean, onCardClick: () -> Unit, onAddClick: () -> Unit) {

    Row(modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = {
                onAddClick()
            },
            modifier = Modifier
                .weight(1f)
                .height(40.dp),
            enabled = !adicionado,
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.surface,
                containerColor = MaterialTheme.colorScheme.primary
            )
        ){
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Adicionar"

            )
            Text("Adicionar", fontSize = 15.sp)
        }

        Button(
            onClick = onCardClick,
            modifier = Modifier
                .weight(1f)
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.surface,
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text("Ver mais", fontSize = 16.sp)
        }
    }
}

//card da pg principal
@Composable
fun CardWithButtons(exercicio: Exercicio,
                    adicionado: Boolean,
                    modifier: Modifier = Modifier,
                    onCardClick: () -> Unit, onAddClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Imagem(Modifier.size(80.dp), exercicio.imagem) //
                LeftCard(exercicio = exercicio)
            }

            Spacer(modifier = Modifier.height(12.dp))

            ButtonsCard(adicionado = adicionado, onCardClick = onCardClick, onAddClick = onAddClick)
        }
    }
}



@Composable
fun ListaExercicios(exercicios: List<Exercicio>, modifier: Modifier, exerciciosSelecionados: List<Exercicio>, onCardClick: (String) -> Unit, onAddClick: (Exercicio) -> Unit,
                    onReturnClick: () -> Unit, onViewListClick: () -> Unit, comprimentoLista: Int) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavBar(Modifier, onReturnClick, onViewListClick, false, true,comprimentoLista )
        },
        containerColor = MaterialTheme.colorScheme.secondary
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(exercicios) { exercicio ->
                CardWithButtons(
                    exercicio = exercicio,

                    adicionado = exerciciosSelecionados.contains(exercicio),
                    onCardClick = { onCardClick(exercicio.nome) },
                    onAddClick = { onAddClick(exercicio) }
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ExerciciosPreview() {
    AcademiaTheme() {
        ListaExercicios(
            exercicios = DataSource.Exercicios,
            onCardClick = { },
            onViewListClick = { },
            onReturnClick = {},
            onAddClick = {},
            comprimentoLista = 8,
            exerciciosSelecionados = emptyList(),
            modifier = Modifier
        )
    }
}
