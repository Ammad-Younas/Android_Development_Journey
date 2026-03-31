class BankAccount (
    val accountHolder: String,
    var balance: Double,
    ) {

    private val transactionHistory = mutableListOf<String>()

    fun deposit (amount: Double) {
        balance += amount
        transactionHistory.add("$accountHolder deposit $$amount")
    }

    fun withdraw (amount: Double) {
        if (amount <= balance) {
            balance -= amount
            transactionHistory.add("$accountHolder withdraw $$amount")
        }
        else {
            println("You don't have enough balance to withdraw!")
        }
    }

    fun showTransactionHistory() {
        println("Transaction History of $accountHolder")
        for (transaction in transactionHistory) {
            println(transaction)
        }
        println("Total balance is: $$balance")
    }
}