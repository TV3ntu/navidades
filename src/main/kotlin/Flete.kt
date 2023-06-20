package ar.edu.unsam.algo2

class Flete(val remitente: String, val remitenteDni: String) {
    val envios = mutableListOf<Int>()
    fun generarCodigoDeEnvio(): Int {
        val codigo = (0..1000000).random()
        if (envios.contains(codigo)) return generarCodigoDeEnvio()
        return codigo
    }
    fun registrarEnvio(nombre: String, dni: String, direccion: String) {
        envios.add(generarCodigoDeEnvio())
    }

}
