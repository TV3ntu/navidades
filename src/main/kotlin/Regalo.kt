package ar.edu.unsam.algo2

import java.time.LocalDate

open class Regalo(var precio: Int, val marca: String) {

    open fun esValioso(): Boolean = precio > 5000
}

class Ropa(precio: Int, marca: String) : Regalo(precio, marca){
    fun esDeMarca(): Boolean {
        val marcas = listOf("Jordache", "Lee", "Charro", "Motor Oil")
        return marca in marcas
    }
    override fun esValioso(): Boolean = super.esValioso() && esDeMarca()
}

class Juguetes(precio: Int, marca: String, val FechaDeFabricacion: LocalDate) : Regalo(precio, marca){
    fun esDeColeccion(): Boolean = FechaDeFabricacion.year < 2000

    override fun esValioso(): Boolean = super.esValioso() && esDeColeccion()
}

class Perfume(precio: Int, marca: String, val origen: String) : Regalo(precio, marca){
    fun esImportado(): Boolean = origen != "Argentina"

    override fun esValioso(): Boolean = super.esValioso() && esImportado()
}

class Experiencia(precio: Int, marca: String, val fecha: LocalDate): Regalo(precio, marca){
    fun esViernes(): Boolean = fecha.dayOfWeek.name == "FRIDAY"

    override fun esValioso(): Boolean = super.esValioso() && esViernes()
}

class Voucher(precio: Int, marca: String) : Regalo(precio, marca){
    override fun esValioso(): Boolean = false
}