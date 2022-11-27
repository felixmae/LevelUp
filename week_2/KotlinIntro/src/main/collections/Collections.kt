import java.lang.Math.abs

fun main() {
    //List == is an ordered collection of items
    val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)
    //set == is an unordered collection that does not support duplicates
    val openIssues: MutableSet<String> = mutableSetOf("uniqueDescr1", "uniqueDescr2", "uniqueDescr3")
    //map == is a collection of key/value pairs, where each key is unique and is used to retrieve the corresponding value
    val EZPassAccounts: MutableMap<Int, Int> = mutableMapOf(1 to 100, 2 to 100, 3 to 100)

    //-------------------------------------------
    //filter
    println("---------------")
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    println(numbers.filter { x -> x > 0 })
    println(numbers.filter { it < 0 })

    //map
    println("---------------")
    println(numbers.map { x -> x * 2 })
    println(numbers.map { it * 3 })

    //any, all, none
    val anyNegative = numbers.any { it < 0 } //return true if the collection matches the given predicate
    val allEven = numbers.all { it % 2 == 0 }   // return true if all elements in collection matches the given predicate
    val allLess6 = numbers.all { it < 6 }
    val noneEven =
        numbers.none { it % 2 == 1 } // returns true if there are no elements that match the given predicate in the collection.
    val allnoneess6 = numbers.none { it > 6 }

    //find, findLast
    val words = listOf("Lets", "find", "something", "in", "collection", "somehow")
    val first =
        words.find { it.startsWith("some") }   //eturn the first or the last collection element that matches the given predicate
    val last = words.findLast { it.startsWith("some") }
    val nothing = words.find { it.contains("nothing") }

    //first, last
    println(numbers.first()) //return the first and the last element of the collection correspondingly
    println(numbers.last())
    val firstEven = numbers.first { it % 2 == 0 }
    val lastOdd = numbers.last { it % 2 != 0 }
    val firstF = words.firstOrNull { it.startsWith('f') }  // 5

    //firstOrNull, lastOrNull These functions work almost the same way with one difference: they return null if there are no matching elements.
    val firstFs = words.firstOrNull { it.startsWith('f') }  // 5
    val firstZs = words.firstOrNull { it.startsWith('z') }  // 6
    println(words.lastOrNull())

    //count functions returns either the total number of elements in a collection or the number of elements matching the given predicate
    val evenCount = numbers.count { it % 2 == 0 }

    //groupBy,
    val numbers2 = listOf(-2, -1, 0, 1)
    println(numbers2.groupBy { it < 0 }) // {true=[-2, -1], false=[0, 1]}
    println("Develou.com".associateBy { it.toByte() }) // {68=D, 101=e, 118=v, 108=l, 111=o, 117=u, 46=., 99=c, 109=m}
    println(numbers.associateBy { 1 }) // {1=-6} //recorre el array y va mostrando un mapa clave valor, en este caso muestra unicamente el ultimo valor

    //partition
    val evenOdd = numbers.partition { it % 2 == 0 } //function splits the original collection into a pair of lists using a given predicate
    val (positives, negatives) = numbers.partition { it > 0 }
    /*Even numbers: [-2, -4, -6]
        Odd numbers: [1, 3, 5]
        Positive numbers: [1, 3, 5]
        Negative numbers: [-2, -4, -6]
    * */

    //flatmap  transforms each element of a collection into an iterable object and builds a single list of the transformation results
    val fruitsBag = listOf("apple","orange","banana","grapes")
    val clothesBag = listOf("shirts","pants","jeans")
    val cart = listOf(fruitsBag, clothesBag)
    val mapBag = cart.map { it }    // [[apple, orange, banana, grapes], [shirts, pants, jeans]]
    val flatMapBag = cart.flatMap { it } //[apple, orange, banana, grapes, shirts, pants, jeans]

    //minOrNull, maxOrNull functions return the smallest and the largest element of a collection. If the collection is empty, they return null
    println("Numbers: $numbers, min = ${numbers.minOrNull()} max = ${numbers.maxOrNull()}")

    //sorted returns a list of collection elements sorted according to their natural sort order (ascending).
    val shuffled = listOf(5, 4, 2, 1, 3, -10)
    val natural = shuffled.sorted()//[-10, 1, 2, 3, 4, 5]
    val inverted = shuffled.sortedBy { -it }//[5, 4, 3, 2, 1, -10]
    val descending = shuffled.sortedDescending() //[5, 4, 3, 2, 1, -10]
    val descendingBy = shuffled.sortedByDescending { abs(it)  }// [-10, 5, 4, 3, 2, 1]

    //map
    val map = mapOf("key" to 42)
    val value3: Int = map.getValue("key") //return the value corresponding to the key
    val mapWithDefault = map.withDefault { k -> k.length } //For maps created with withDefault, getValue returns the default value instead of throwing an exception.
    val value4 = mapWithDefault.getValue("key2")
    try {
        map.getValue("anotherKey")
    } catch (e: NoSuchElementException) {
        println("Message: $e")
    }

    //zip  function merges two given collections into a new collection
    val A = listOf("a", "b", "c")
    val B = listOf(1, 2, 3, 4)

    val resultPairs = A zip B //[(a, 1), (b, 2), (c, 3)]
    val resultReduce = A.zip(B) { a, b -> "$a$b" } //$A$B: [a1, b2, c3]


    //getOrElse provides safe access to elements of a collection.
    val list = listOf(0, 10, 20)
    println(list.getOrElse(1) { 42 })    //0
    println(list.getOrElse(10) { 42 })   //42

}