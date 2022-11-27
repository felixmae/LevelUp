class Coffee() {
    var clientName: String? = null
    fun doCoffee() {}
}

fun sellCoffee(name: String): Coffee {
    val coffee = Coffee()
    return coffee.apply {
        clientName = name
        doCoffee()
    }
}

fun serveCoffee(coffee: Coffee) {}

fun main() {
    println("Ingrese el nombre del cliente")
    val name = readLine().toString()
    serveCoffee(sellCoffee(name))
}