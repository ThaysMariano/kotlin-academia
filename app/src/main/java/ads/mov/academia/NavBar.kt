package ads.mov.academia

import ads.mov.academia.ui.theme.AcademiaTheme
import ads.mov.academia.ui.theme.branco
import ads.mov.academia.ui.theme.rosa
import ads.mov.academia.ui.theme.rosaClaro
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.sync.Mutex

class NavBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AcademiaTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavBar(modifier = Modifier.padding(innerPadding),
                        {}, {}, true, true, 5)
                }
            }
        }
    }
}
@Composable
fun NavBar(modifier: Modifier, onReturnClick: ()-> Unit, onViewListClick: () -> Unit, voltar: Boolean, listagem: Boolean, comprimentoLista: Int){
    Row(modifier = modifier.fillMaxWidth().background(rosaClaro)
        .height(80.dp)
        .drawBehind({drawLine(Color.White, start = Offset(0f, 0f), end = Offset(size.width, 0f), strokeWidth = 1.dp.toPx())})
        ,verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround ){
        if( voltar){
            Button(onClick = onReturnClick,
                modifier.height(45.dp).weight(1f).padding(start =25.dp, end = 25.dp),
                colors = ButtonDefaults.buttonColors(contentColor = branco, containerColor = rosa),
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Voltar"
                )
                Text(
                    text = "Voltar",
                    modifier = Modifier.padding(start = 8.dp),
                    fontWeight = FontWeight.Bold,

                    )
            }
        }

        if( listagem){
            //pegar o lenght da lista
            TextButton(onClick = onViewListClick,
                modifier.height(45.dp).weight(1f).padding(start =25.dp, end = 25.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = branco,
                    containerColor = rosa
                )) {
                Text(text ="Ver Lista",
                    modifier = Modifier.padding(start = 8.dp, end =8.dp),
                    fontWeight = FontWeight.Bold)
                Text(text = comprimentoLista.toString(),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NavBarPreview() {
    NavBar(Modifier, onReturnClick = {}, onViewListClick = {}, true, true, 3)
}