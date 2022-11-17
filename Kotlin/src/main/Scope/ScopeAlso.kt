class Car(val model: String, val motor: Float) {
    fun makeCar() {}
}

fun updateCompayRecords(car: Car) {}

fun informPolice(car: Car) {}

fun main() {
    val newCar = Car("etios", 1.5F)
    newCar.also {
        it.makeCar()
        updateCompayRecords(it)
        informPolice(it)
    }
}