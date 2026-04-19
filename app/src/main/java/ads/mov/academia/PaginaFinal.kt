package ads.mov.academia

import ads.mov.academia.ui.theme.AcademiaTheme
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.font.FontWeight


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListaExerciciosSelecionados(exercicios: List<Exercicio>, onReturnClick: () -> Unit,
                                onViewListClick: () -> Unit
) {
    Scaffold(
        bottomBar = {
            NavBar(Modifier, onReturnClick, onViewListClick, true, false, comprimentoLista = 3)
        },
        containerColor = MaterialTheme.colorScheme.secondary
    ) { paddingValues ->
        if(!exercicios.isEmpty()){
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(exercicios) { exercicio ->
                    CartaoExercicio(exercicio = exercicio,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(4.dp))
                }

            }
        }else{
            Box(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {

                Text(
                    text = "Adicione exercícios para vê-los listados aqui!",
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    modifier = Modifier.padding(16.dp),
                    color = Color.Black,
                    fontSize = 20.sp

                )


            }

        }

    }
}

@Preview(showBackground = true, showSystemUi = true) // showSystemUi mostra a barra de status/navegação
@Composable
fun ExerciciosFinalPreview() {
    AcademiaTheme() {
        ListaExerciciosSelecionados(
            exercicios = DataSource.Exercicios,
            onReturnClick = {},
            onViewListClick = {},
        )
    }
}