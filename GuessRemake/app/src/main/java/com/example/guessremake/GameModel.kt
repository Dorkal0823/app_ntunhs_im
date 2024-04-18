package com.example.guessremake
import java.util.Random
class GameModel {
    var secret = generateSecret()

    private fun generateSecret() = Random().nextInt(10) + 1

    fun validateGuess(guess: Int): String {
        return when {
            guess > secret -> "猜小一點"
            guess < secret -> "猜大一點"
            else -> "猜對了！"
        }
    }

    fun resetGame() {
        secret = generateSecret()
    }
}