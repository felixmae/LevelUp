fun main() {
    val trickFunctionReference = ::trick
    val trickFunction = trick
    trick()
    trickFunction()

    treat()

    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val cupcake: (Int) -> String = {
        "Have a cupcake!"
    }
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true)
    repeat(4) {
        treatFunction()
    }

    trickFunction()

}

fun trick() {
    println("No treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}


fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}
