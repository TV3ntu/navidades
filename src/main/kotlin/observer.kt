package ar.edu.unsam.algo2

interface Observer {
    fun update(regalo: Regalo, persona: Persona)
}

class envioDeMail() : Observer {
    override fun update(regalo: Regalo, persona: Persona) {
        println("Se envio un mail a ${persona.email} para informarle que se le envio un regalo")
    }
}

class InformarEmpresaDeEnvios(var flete: Flete) : Observer {
    override fun update(regalo: Regalo, persona: Persona) {
        flete.registrarEnvio(persona.nombre, persona.documento, persona.direccion)
    }
}

class modificarCriterio(var persona: Persona) : Observer {
    override fun update(regalo: Regalo, persona: Persona) {
        persona.perfil = Interesado(persona)
        persona.limite = 5000
    }
}