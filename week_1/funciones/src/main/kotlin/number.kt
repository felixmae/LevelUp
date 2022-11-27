fun main() {
    println(number(5,3,"Hola mundo!!"))
}

fun number(num1: Int, num2: Int, text: String): Int {
    val size = text.length
    if (size > 10)
        return num1 + num2
    else
        return num1 * num2
}