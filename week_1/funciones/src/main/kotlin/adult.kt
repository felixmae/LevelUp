fun main() {
    val age = 21
    val adult = isAdult(age)
    println("Es mayor de edad = $adult")
}

fun isAdult(age: Int): Boolean{
    return age >= 21
}