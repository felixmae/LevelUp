fun main(args: Array<String>) {

    // ---
    val alumniCount = 10

    println("We are $alumniCount alumni") // We are 10 alumni

    // ---
    val firstNumber = 10
    val secondNumber = 20

    println("The summary is ${firstNumber * secondNumber}") // The summary is 200

    // ---
    var totalAmount = 20.5
    totalAmount *= 3

    println("The total amount is $totalAmount")

    // ---
    var measure: Double = 30.5
    println("We are at $measure degrees.")
    measure += 5
    println("We are at $measure degrees.")

    // ---
    val teamName: String?
    var teamCity: String?
    var teamCups: Int = 10

    teamName = "Rayo Vallecano"
    teamCity = "Madrid"

    println("I'm proud of my team $teamName which is from $teamCity. They won $teamCups times")

    teamCity = "Bilbao"
    println("I'm proud of my team $teamName which is from $teamCity. They won $teamCups times")

    // ---
    val task: Int = 32450
    var pendingTask: Int = 16768

    println("I've finished task $task and misses $pendingTask")

    // ---
    val myName: String?
    myName = "Felix"

    println("My name has ${myName?.length} characters")
}