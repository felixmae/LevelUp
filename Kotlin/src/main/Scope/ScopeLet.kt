fun readClient(): String? {
    return readln().ifEmpty { null }
}

fun main() {
    println("Ingrese nombres de clientes, finaliza con Alto")
    val cliente = mutableListOf<String>()
    var continueLoop = true
    do {
        readClient()?.let {
            if (it.contains("Alto")) continueLoop = false
            else cliente.add(it)
        }
    } while (continueLoop)
    cliente.map {
        println("Hola $it!!")
    }
}