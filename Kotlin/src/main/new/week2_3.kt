data class Shop (val name: String, val customers: List<Customer>)

data class Customer(val name: String, val city: City, val orders: List<Order>)

data class Order(val products: List<Product>, val isDelivery: Boolean)

data class Product(var name: String, val price: Double){
    override fun toString(): String {
        return "$name for $price"
    }
}

data class City(val name: String){
    override fun toString(): String {
        return name
    }
}



const val POINTS_X_PASS: Int = 15
val EZPassAccounts: MutableMap<Int, Int> = mutableMapOf(1 to 100, 2 to 100, 3 to 100)   // 1
val EZPassReport: Map<Int, Int> = EZPassAccounts                                        // 2

fun updatePointsCredit(accountId: Int) {
    if (EZPassAccounts.containsKey(accountId)) {                                        // 3
        println("Updating $accountId...")
        EZPassAccounts[accountId] = EZPassAccounts.getValue(accountId) + POINTS_X_PASS  // 4
    } else {
        println("Error: Trying to update a non-existing account (id: $accountId)")
    }
}

fun accountsReport() {
    println("EZ-Pass report:")
    EZPassReport.forEach {                                                              // 5
            k, v -> println("ID $k: credit $v")
    }
}

fun main() {
    accountsReport()                                                                    // 6
    updatePointsCredit(1)                                                               // 7
    updatePointsCredit(1)
    updatePointsCredit(5)                                                               // 8
    accountsReport()                                                                    // 9

  //  fun Shop.getSetOfCustomers(): Set<Customer> = customers.toSet()


}