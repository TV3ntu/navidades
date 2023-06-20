package ar.edu.unsam.algo2

abstract class Subject(){
    val observers = mutableListOf<Observer>()
    fun agregarObserver(observer: Observer){
        observers.add(observer)
    }
    fun notificarObservers(regalo: Regalo, persona: Persona){
        observers.forEach { observer -> observer.update(regalo, persona) }
    }
    fun removerObserver(observer: Observer){
        observers.remove(observer)
    }


}
class PapaNoel(): Subject() {
    val regalosEnStock = listOf<Regalo>()
    val regalosEntregados = mutableListOf<Regalo>()
    fun elegirRegaloPara(persona: Persona): Regalo {
        if (existeRegaloPara(persona))
            return regalosEnStock.first { regalo -> persona.leGusta(regalo) }
        return generarRegaloConsuelo()
    }

    fun generarRegaloConsuelo(): Regalo {
        return Voucher(2000, "Papapp")
    }
    fun existeRegaloPara(persona: Persona): Boolean {
        return regalosEnStock.any { regalo -> persona.leGusta(regalo) }
    }
    fun regalar(persona: Persona){
        val regalo = elegirRegaloPara(persona)
        persona.regalosRecibidos.add(regalo)
        regalosEntregados.add(regalo)
        notificarObservers(regalo, persona)
    }

}