fun main(args: Array<String>) {
    val auto = Auto("Ford","Figo")


}
class Auto(val marca: String, val modelo: String) {
/*    init{
        println("Estoy creando ub auto")
    }

    constructor(marca: String, modelo: String, transmitcion: String) : this (marca, modelo){
        println("Tengo un $marca $modelo de transmisión $transmitcion")
    }*/
    //header
    private var _transmicion: String? = null
    var transmicion: String?
        get () = _transmicion + "hola"
        set (a: String?) { _transmicion = a }

    companion object {
        @JvmStatic
        val TAG = "Auto"

        @JvmStatic
        fun frenarAllCarros() {}
    }

    //body
    fun arrancar(conductor: String, hasLlave: Boolean): Boolean {return true}

    fun frenar():Boolean {return true}
}