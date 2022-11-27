class Portatil (){
    var state = "on"
    fun turnOn(){state = "on"}
    fun turnOff(){state = "off"}
    fun checkState(){
        println("State $state")
    }
}

fun main () {
val newPortatil = Portatil()
    newPortatil.run {
        this.turnOff()
        this.checkState()
        this.turnOn()
        this.checkState()
    }
}