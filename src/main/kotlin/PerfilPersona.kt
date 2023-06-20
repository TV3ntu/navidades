package ar.edu.unsam.algo2

interface PerfilPersona {
    fun leGusta(regalo: Regalo): Boolean
}

class Conformista : PerfilPersona {
    override fun leGusta(regalo: Regalo): Boolean = true
}

class Interesado(var persona: Persona) : PerfilPersona {
    fun esCaro(precio: Int): Boolean = precio > persona.limite
    override fun leGusta(regalo: Regalo): Boolean = esCaro(regalo.precio)
}

class Exigente : PerfilPersona {
    override fun leGusta(regalo: Regalo): Boolean = regalo.esValioso()
}

class Marquero(var marcaPreferida: String) : PerfilPersona {
    override fun leGusta(regalo: Regalo): Boolean = regalo.marca == marcaPreferida
}

class Combineta(var perfiles: List<PerfilPersona>) : PerfilPersona {
    override fun leGusta(regalo: Regalo): Boolean = perfiles.any { perfil -> perfil.leGusta(regalo) }
}