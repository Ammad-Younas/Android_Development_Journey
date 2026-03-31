data class CoffeeItems (
    val name: String,
    val sugarCount: Int,
    val creamCount: Int
)

fun main(){
    print("Enter your name: ")
    val name = readln().replaceFirstChar(Char::titlecaseChar)

    print("Enter your sugar count: ")
    val sugarCount = readln().toInt()

    print("Enter your cream count: ")
    val creamCount = readln().toInt()

    val coffeeCustomer = CoffeeItems(name, sugarCount, creamCount)
    makeCoffee(coffeeCustomer)
}

fun makeCoffee(coffeeItems: CoffeeItems){
    val orderDetails : String = when (coffeeItems.sugarCount) {
        1 -> "Order Placed for ${coffeeItems.name} with ${coffeeItems.sugarCount} spoon of sugar and ${coffeeItems.creamCount} cream"
        else -> "Order Placed for ${coffeeItems.name} with ${coffeeItems.sugarCount} spoons of sugar and ${coffeeItems.creamCount} cream"
    }
    print(orderDetails)
}