fun main() {
    val ammadAccount = BankAccount("Ammad Younas", 5000.00)
    ammadAccount.deposit(1000.0)
    ammadAccount.withdraw(1000.0)
    ammadAccount.deposit(14500.0)
    ammadAccount.withdraw(15000.0)

    ammadAccount.showTransactionHistory()
}