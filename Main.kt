import Practic1.ChatBot
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

fun isNumber(number: String) : Boolean{
    return try{
        number.toInt()
        if (number.toInt() > 1){
            throw NumberFormatException()
        }
        true
    } catch (e: NumberFormatException){
        println("You inputted wrong value!\nTry again!")
        false
    }
}