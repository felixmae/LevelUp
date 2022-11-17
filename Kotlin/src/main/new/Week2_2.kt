val animals = arrayListOf("leon", "cebra", "mono", "elefante")
fun main() {

    animals.add("panda")
    println(animals)
    animals.remove("leon")
    println(animals)
    checkAnimals("elefante")
    checkAnimals("jirafa")

}

fun checkAnimals(animal: String) {
    println(
        (if (animals.contains(animal)) "El zoo tiene " else "El zoo no tiene ")
                + "$animal"
    )
}