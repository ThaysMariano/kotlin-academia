
import ads.mov.academia.Detalhes
import ads.mov.academia.Exercicio
import ads.mov.academia.PaginaInicial
import ads.mov.academia.ui.theme.AcademiaTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun App() {
    val navController = rememberNavController()
    val exerciciosSelecionados = remember { mutableStateListOf<Exercicio>() }

    NavHost(navController = navController, startDestination = "inicio") {

        composable("inicio") {
            PaginaInicial(onIniciarClick = { navController.navigate("listagem") }, modifier = Modifier)
        }

        composable("listagem") {
            ads.mov.academia.ListaExercicios(
                exercicios = ads.mov.academia.DataSource.Exercicios,
                exerciciosSelecionados = exerciciosSelecionados,
                onCardClick = { nome ->
                    navController.navigate("detalhes/$nome")
                },
                onReturnClick = { navController.navigate("inicio") },
                onViewListClick = { navController.navigate("confirmacao") },

                onAddClick = { exercicio ->
                    if (!exerciciosSelecionados.contains(exercicio)) {
                        exerciciosSelecionados.add(exercicio)
                    }
                },
                comprimentoLista = exerciciosSelecionados.size,
                modifier = Modifier
            )
        }

        composable("detalhes/{nomeExercicio}") { backStackEntry ->
            val nome = backStackEntry.arguments?.getString("nomeExercicio")
            val exercicio = ads.mov.academia.DataSource.Exercicios.find { it.nome == nome }

            exercicio?.let {
                Detalhes(
                    exercicio = it,
                    adicionado = exerciciosSelecionados.contains(it),
                    modifier = Modifier,

                    onReturnClick = { navController.navigate("listagem") },
                    onViewListClick = { navController.navigate("confirmacao") },
                    onAddClick = {
                        if (!exerciciosSelecionados.contains(it)) {
                            exerciciosSelecionados.add(it)
                        }
                    },
                    comprimentoLista = exerciciosSelecionados.size
                )
            }
        }
        composable("confirmacao") {
            ads.mov.academia.ListaExerciciosSelecionados(
                exercicios = exerciciosSelecionados,
                onReturnClick = { navController.navigate("listagem") },

                onViewListClick = { navController.navigate("confirmacao") }
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppNavigationPreview() {
    AcademiaTheme() {
        App()
    }
}