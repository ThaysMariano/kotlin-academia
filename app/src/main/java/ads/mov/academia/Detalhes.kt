package ads.mov.academia

import ads.mov.academia.ui.theme.AcademiaTheme
import ads.mov.academia.ui.theme.branco
import ads.mov.academia.ui.theme.rosa
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ImagemDetalhe(modifier: Modifier = Modifier, id: Int){
    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        modifier.height(40.dp).padding(10.dp)
        )
}
@Composable
fun Detalhes(
    exercicio: Exercicio,
    adicionado: Boolean,
    modifier: Modifier = Modifier,
    onReturnClick: () -> Unit,
    onViewListClick: () -> Unit,
    onAddClick: () -> Unit,
    comprimentoLista: Int
) {
    Scaffold(
        bottomBar = { NavBar(modifier, onReturnClick, onViewListClick, true, true,comprimentoLista ) }
    ) { paddingValues ->

        Column(
            modifier = modifier
                .fillMaxSize().padding(paddingValues)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = exercicio.nome,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 24.dp, bottom = 15.dp)
            )

            ImagemDetalhe(Modifier.size(240.dp).fillMaxWidth(), exercicio.imagem)

            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Repetições", fontSize = 14.sp,
                        color = Color.Black, fontWeight = Bold)
                    Text(exercicio.repeticoes.toString(),
                        fontWeight = FontWeight.SemiBold)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "Duração/Rep",
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontWeight = Bold
                    )
                    Text("${exercicio.tempo}s", fontWeight = FontWeight.SemiBold)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Foco", fontSize = 14.sp,
                        color = Color.Black,
                        fontWeight = Bold)
                    Text(exercicio.corpo,
                        fontWeight = FontWeight.SemiBold)
                }
            }


            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 10.dp, bottom = 40.dp, end = 20.dp, start = 20.dp)
            ) {
                Text(
                    "Descrição",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black,

                )

                Text(
                    text = exercicio.descricaoLonga,
                    textAlign = TextAlign.Justify,
                    lineHeight = 20.sp
                )
            }

            Button(
                onClick = onAddClick,
                enabled = !adicionado,
                modifier = Modifier.fillMaxWidth().height(48.dp)
                    .padding(start = 16.dp, end = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = MaterialTheme.colorScheme.surface,
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    if (adicionado) {
                        "Adicionado"
                    } else {
                        "Adicionar à Lista"
                    },
                    fontSize = 18.sp

                )
            }

        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetalhesPreview() {
    AcademiaTheme() {
        val exemplo = ads.mov.academia.Exercicio(
            "Agachamento", "Desc", "Desc Longa", 12, 60, "Inferior", R.drawable.prancha
        )
        Detalhes(exercicio = exemplo, adicionado = false, Modifier, onReturnClick = {}, onViewListClick = {}, onAddClick = {}, 4)
    }
}