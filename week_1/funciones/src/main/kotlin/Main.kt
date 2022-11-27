fun main() {
    println(birthdayGreeting("Rover", 5))
    println(birthdayGreeting2(age = 5))
    println(birthdayGreeting2("Rex", 2))


}


fun birthdayGreeting(name: String, age: Int): String {
    val nameGreeting = "Happy Birthday, $name!"
    val ageGreeting = "You are now $age years old!"
    return "$nameGreeting\n$ageGreeting"
}

fun birthdayGreeting2(name: String = "Rover", age: Int): String {
    return "Happy Birthday, $name! You are now $age years old!"
}
