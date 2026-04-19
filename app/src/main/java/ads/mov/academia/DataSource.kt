package ads.mov.academia

data class Exercicio(val nome: String, val descricao: String, val descricaoLonga: String, val repeticoes: Int, val tempo: Int, val corpo: String, val imagem: Int )
object DataSource {
    val Exercicios = listOf(
        Exercicio(
            "Agachamento",
            "Exercício para fortalecer pernas e glúteos, mantendo a coluna reta durante a execução.",
            "Mantenha os pés afastados na largura dos ombros. Flexione os joelhos enviando o quadril para trás, como se fosse sentar em uma cadeira invisível, mantendo o peito aberto e a coluna neutra. Desça até as coxas ficarem paralelas ao chão e retorne à posição inicial pressionando os calcanhares.",
            12,
            60,
            "Inferior",
            R.drawable.agachamento
        ),
        Exercicio(
            "Flexão de Braço",
            "Trabalha peitoral, ombros e tríceps usando o peso do próprio corpo.",
            "Posicione as mãos no chão em uma distância levemente superior à largura dos ombros. Mantenha o corpo alinhado da cabeça aos calcanhares (posição de prancha). Desça o tronco controladamente até o peito quase tocar o solo e empurre com força para subir, mantendo o abdômen sempre contraído.",
            10,
            45,
            "Superior",
            R.drawable.flexao_de_bracos
        ),
        Exercicio(
            "Prancha",
            "Exercício isométrico para fortalecimento do core (abdômen e lombar).",
            "Apoie os antebraços no chão, alinhando os cotovelos logo abaixo dos ombros. Estenda as pernas para trás, apoiando-se na ponta dos pés. O segredo é a estabilidade: não deixe o quadril subir nem cair. Respire de forma pausada enquanto mantém a tensão em toda a região abdominal e lombar.",
            1,
            60,
            "Core",
            R.drawable.prancha_dois
        ),
        Exercicio(
            "Supino Reto",
            "Exercício com barra ou halteres focado no desenvolvimento do peitoral.",
            "Deitado no banco, mantenha os pés firmes no chão. Segure a barra com uma pegada firme, desça-a lentamente até a linha do peitoral, controladamente a fase excêntrica. Expire ao empurrar a carga verticalmente, focando na contração máxima das fibras do peitoral sem travar totalmente os cotovelos no topo.",
            10,
            60,
            "Superior",
            R.drawable.supino_reto
        ),
        Exercicio(
            "Corrida na Esteira",
            "Atividade cardiovascular para melhorar resistência e queima de calorias.",
            "Inicie com um trote leve para aquecimento das articulações. Mantenha o olhar para o horizonte e os braços em um ângulo de 90 graus, movendo-os alternadamente com as passadas. Foque em uma aterrissagem suave com o meio do pé para minimizar o impacto nos joelhos e mantenha uma respiração rítmica.",
            1,
            900,
            "Cardio",
            R.drawable.esteiraa
        )
    )
}