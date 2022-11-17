class Store(var zapatos: Int, var camisas: Int, var chaquetas: Int) {
    fun printStock() {
        println(
            "Quedan: $zapatos zapatos,\n" +
            "        $camisas camisas,\n" +
            "        $chaquetas chaquetas"
        )
    }
}

fun main() {
    val store = Store(0, 0, 0)
    with(store) {
        camisas = 8
        chaquetas = 20
        zapatos = 5
        printStock()
    }
}