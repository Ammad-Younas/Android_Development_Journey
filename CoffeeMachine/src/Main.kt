//import java.util.Locale

fun main() {
    print("Enter your name: ")

    //    First Approach
    val name = readln().replaceFirstChar(Char::titlecaseChar)

//    //    Second Approach
//    val name1 = readln().replaceFirstChar {
//        if (it.isLowerCase()) {
//            it.titlecase(Locale.getDefault())
//        }
//        else {
//            it.toString()
//        }
//    }
//
//    //    Third Approach
//    val name2 = readln().replaceFirstChar {
//        when {
//            it.isLowerCase() -> it.titlecase(Locale.getDefault())
//            else -> it.toString()
//        }
//    }
//
//    //    Fourth Approach
//    val name3 = readln().replaceFirstChar {
//        when {
//            it.isLowerCase() -> it.titlecaseChar()
//            else -> it.titlecaseChar()
//        }
//    }
    
    
    print("Enter your sugar count: ")
    val sugarCount = readln().toInt()

    makeCoffee(name, sugarCount)
}

fun makeCoffee(name: String, sugarCount : Int) {
    when (sugarCount) {
        1 -> {
            println("$name's Coffee with $sugarCount spoon of sugar")
        }

        else -> {
            println("$name's Coffee with $sugarCount spoons of sugar")
        }
    }
}