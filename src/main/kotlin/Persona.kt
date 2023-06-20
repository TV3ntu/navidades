package ar.edu.unsam.algo2

class Persona(val nombre: String,
              var perfil: PerfilPersona,
              val email: String,
              val documento: String,
              val direccion: String,
              var limite: Int) {

    val regalosRecibidos = mutableListOf<Regalo>()
    fun leGusta(regalo: Regalo): Boolean = perfil.leGusta(regalo)
}