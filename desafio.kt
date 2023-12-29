enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(var nome: String, var email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        
        println("${usuario.nome} foi inscrito no curso $nome")
    }
}

fun main() {
    
    val javaBasico = ConteudoEducacional("Java ${Nivel.BASICO}", 100)
    val javaAvancado = ConteudoEducacional("Java ${Nivel.AVANCADO}", 60)
    val javaIntermediario = ConteudoEducacional("Java ${Nivel.INTERMEDIARIO}", 45)
    
    val kotlinBasico = ConteudoEducacional("Kotlin ${Nivel.BASICO}", 75)
    val kotlinAvancado = ConteudoEducacional("Kotlin ${Nivel.AVANCADO}", 60)
    val androidBasico = ConteudoEducacional("Android ${Nivel.BASICO}", 90)  
    
    val conteudos = listOf(javaBasico, javaAvancado, javaIntermediario, kotlinBasico, kotlinAvancado, androidBasico)
        
    val formacaoKotlin = Formacao("Kotlin Fundamentals", listOf(kotlinBasico, kotlinAvancado, androidBasico), nivel = Nivel.INTERMEDIARIO)
    val formacaoJava = Formacao("Java Developer", listOf(javaBasico, javaIntermediario, javaAvancado, androidBasico), nivel = Nivel.AVANCADO)
    
    val formacoes = listOf(formacaoKotlin, formacaoJava)

    val usuarioUm = Usuario("João Figueiredo", "jojo@gmail.com")
    val usuarioDois = Usuario("Renata Silveira", "resilveira@gmail.com")
    val usuarioTres = Usuario("Lucas Costa", "lucosta@hotmail.com")
    val usuarioQuatro = Usuario("Gilmar Gili", "gili@gmail.com")

    formacaoKotlin.matricular(usuarioUm)
    formacaoKotlin.matricular(usuarioDois)
    formacaoJava.matricular(usuarioTres)
    formacaoJava.matricular(usuarioQuatro)
    formacaoKotlin.matricular(usuarioQuatro)

    println("\nFormações disponíveis: ${formacoes.map { it.nome }}\n")
    for (formacao in formacoes){
        println("Formação: ${formacao.nome} - Nível: ${formacao.nivel}")
        println("Inscritos na ${formacao.nome}: ${formacao.inscritos.map { it.nome }}")
    }
    
    println("\nConteúdos para estudo: ")
    for(conteudo in conteudos){
        println("Curso: ${conteudo.nome} - Carga Horária: ${conteudo.duracao}h")
    }

}
