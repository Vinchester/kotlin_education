import Practic1.ChatBot
import Practic2.Hangman
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main() {
    println("Input, which practic you want to see")
    var selection: String

    do{
        print(">")
        selection = readLine().toString()
    }while(!isNumber(selection))

    when(selection){
        "1" -> startPractic1()
        "2" -> startPractic2()
    }

}

fun startPractic1() {
    val chatBotName: String = "Kotlin bot"
    val year = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy"))
    val chatBot: ChatBot = ChatBot(chatBotName, year)
    chatBot.printHelloMenu()
    chatBot.guessAge()
    chatBot.counting()
}

fun startPractic2() {
    val hangman: Hangman = Hangman()
    hangman.printHelloMenu()
    println("Correct answer is $hangman.word")
    while (!hangman.compareWords(hangman.unsweredPart)) {
        hangman.game()
    }

    if ((hangman.compareWords(hangman.unsweredPart)) && (hangman.tries != 0)){
        println("You won!")
    } else {
        println("You lost\nCorrect answer is ${hangman.word}")
    }

}

fun isNumber(number: String) : Boolean{
    return try{
        number.toInt()
        if (number.toInt() > 2){
            throw NumberFormatException()
        }
        true
    } catch (e: NumberFormatException){
        println("You inputted wrong value!\nTry again!")
        false
    }
}