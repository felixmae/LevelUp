fun main () {
    val list = listOf("Jessica", "Henry", "Alicia", "Jose")


    for (item in list) println(item) // Iterate over items in a list

    for (item in 'b'..'g') println(item) // Range of characters in an alphabet

    for (item in 1..5) println(item) // Range of numbers

    for (item in 5 downTo 1) println(item) // Going backward

    for (item in 3..6 step 2) println(item) // Prints: 35

}