fun main() {
    var computerChoice = ""

    print("Enter your choice (Rock, Paper, Scissor): ")
    val playerChoice = readln().lowercase()

    val randomNumber = (1..3).random()

    when (randomNumber) {
        1 -> {
            computerChoice = "rock"
        }
        2 -> {
            computerChoice = "paper"
        }
        3 -> {
            computerChoice = "scissor"
        }
    }

    val winner = when {
        playerChoice == computerChoice -> "Computer chose ${computerChoice.uppercase()} and Player chose ${playerChoice.uppercase()}: Winner is ==> Tie"
        playerChoice == "rock" && computerChoice == "scissor" -> "Computer chose ${computerChoice.uppercase()} and Player chose ${playerChoice.uppercase()}: Winner is ==> Player"
        playerChoice == "paper" && computerChoice == "rock" -> "Computer chose ${computerChoice.uppercase()} and Player chose ${playerChoice.uppercase()}: Winner is ==> Player"
        playerChoice == "scissor" && computerChoice == "paper" -> "Computer chose ${computerChoice.uppercase()} and Player chose ${playerChoice.uppercase()}: Winner is ==> Player"
        else -> "Computer chose ${computerChoice.uppercase()} and Player chose ${playerChoice.uppercase()}: Winner is ==> Computer"
    }

    print(winner)
}