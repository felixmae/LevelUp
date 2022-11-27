fun main(args: Array<String>) {
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    println("List: $numbers")
    println("Size: ${numbers.size}")

    // Access elements of the list
    println("First element: ${numbers[0]}")
    println("Second element: ${numbers[1]}")
    println("Last index: ${numbers.size - 1}")
    println("Last element: ${numbers[numbers.size - 1]}")
    println("First: ${numbers.first()}")
    println("Last: ${numbers.last()}")

    // Use the contains() method
    println("Contains 4? ${numbers.contains(4)}")
    println("Contains 7? ${numbers.contains(7)}")

    println("-------------")
    val colors = listOf("green", "orange", "blue")
//    colors.add("purple")  //Error no es mutable
//    colors[0]=("purple")  //Error no es mutable
    println("Reverse List: ${colors.reversed()}")
    println("Sorted List: ${colors.sorted()}")
    println("List: $colors")

    val oddNumbers = listOf(5, 3, 7, 1)
    println("List: $oddNumbers")
    println("Sorted list: ${oddNumbers.sorted()}")


}