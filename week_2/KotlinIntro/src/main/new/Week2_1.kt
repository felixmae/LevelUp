fun main(args: Array<String>) {
    /*    val numbers: List<Int> = listOf(1,2,3,4,5,6)
        println("List: $numbers")
        println("Size: ${numbers.size}")

        //Access element of the list
        println("First element: ${numbers[0]}")
        println("Second element: ${numbers[1]}")
        println("Last Index: ${numbers.size - 1}")
        println("Last Number: ${numbers[numbers.size - 1]}")

        //Use the contains() method
        println("Contains 4? ${numbers.contains(4)}")
        println("Contains 7? ${numbers.contains(7)}")

        //Read only
        val colors = listOf("green", "orange", "blue")
        /*colors.add("purple")
        colors[0]="yellow"*/

        println("Reversed list: ${colors.reversed()}")
        println("List: $colors")

        val oddNumbers = listOf(5, 3, 7, 1)
        println("List: $oddNumbers")
        println("Sorted list: ${oddNumbers.sorted()}")
     */
/*
    //Mutable List
    val entrees = mutableListOf<String>()
    println("Entrees: $entrees")

    // Add individual items using add()
    println("Add noodles: ${entrees.add("noodles")}")
    println("Entrees: $entrees")
    println("Add spaghetti: ${entrees.add("spaghetti")}")
    println("Entrees: $entrees")

    // Add a list of items using addAll()
    val moreItems = listOf("ravioli", "lasagna", "fettuccine")
    println("Add list: ${entrees.addAll(moreItems)}")
    println("Entrees: $entrees")

    // Remove an item using remove()
    println("Remove spaghetti: ${entrees.remove("spaghetti")}")
    println("Entrees: $entrees")
    println("Remove item that doesn't exist: ${entrees.remove("rice")}")
    println("Entrees: $entrees")

    // Remove an item using removeAt() with an index
    println("Remove first element: ${entrees.removeAt(0)}")
    println("Entrees: $entrees")

    // Clear out the list
    entrees.clear()
    println("Entrees: $entrees")

    // Check if the list is empty
    println("Empty? ${entrees.isEmpty()}")
    */
    val guestsPerFamily = listOf(2, 4, 1, 3)
    var totalGuests = 0
    var index = 0
    while (index < guestsPerFamily.size) {
        totalGuests += guestsPerFamily[index]
        index++
    }
    println("Total Guest Count: $totalGuests")

    val names = listOf("Jessica", "Henry", "Alicia", "Jose")
    for (name in names) {
        println("$name - Number of characters: ${name.length}")
    }

}

fun planets ()