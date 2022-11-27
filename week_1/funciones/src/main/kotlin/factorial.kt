fun main() {

    val num = 5
    val factorial = calculateFactorial(num)
    println("Factorial of $num = $factorial")
}

fun calculateFactorial(number: Int): Long {
    var i = 1
    var factorial: Long = 1
    while (i <= number) {
        factorial *= i.toLong()
        i++
    }
    return factorial
}