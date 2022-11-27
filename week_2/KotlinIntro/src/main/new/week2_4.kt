val myLambda = { message: String -> "Mensaje $message from lambda function" }

val myLambda2 = {
    println("Ingrese texto, finaliza con stop")
    var input = ""
    var list = mutableListOf<String>()
    do{
       if(input.isNotEmpty())
           list.add(input)
        input = readLine().toString()
    }while(!input.contains("stop"))
    list
}

fun showClient(callback: () -> List<String>, callback2: (String) -> String): List<String> {
    return callback().map{
         callback2(it)
    }
}

fun main() {
//    val listClient = listOf<String>("Santiago", "Joaquin", "Pablo", "Roberto")
    println(showClient(myLambda2,myLambda))
}
