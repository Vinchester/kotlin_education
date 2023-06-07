package Practic2


class Hangman {
    val words: Array<String> = arrayOf("python", "php", "kotlin", "javascript")
    val word: String = words.random()
    var unsweredPart: String = "_".repeat(word.length)
    var tries: Int = 8

    fun game(){
        println("Unswered part - $unsweredPart\nTries left - $tries")

        var userWord = readLine().toString()
        while (userWord.length > 1 || userWord.isEmpty()) {
            userWord = readLine().toString()
        }

        checkLetterInWord(userWord[0])
    }

    fun checkLetterInWord(letter: Char) {
        if (letter in word) {
            if (letter in unsweredPart) {
                println("No improvements")
                return
            }
            val builder = StringBuilder(unsweredPart)
            for (i in 0 until word.length) {
                if (word[i] == letter) {
                    builder.setCharAt(i, letter)
                }
            }
            unsweredPart = builder.toString()
            println("You're right")
        } else {
            tries -= 1
            println("There is no such letter in word")
        }
    }

    fun compareWords(userWord: String) : Boolean{
        if (tries == 0){
            return true
        }
        return (userWord.lowercase() == word.lowercase())
    }

    fun printHelloMenu() {
        println("HANGMAN")
        println("The game will be available soon.")
    }
}