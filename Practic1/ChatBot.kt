package Practic1

class ChatBot(_name: String, _year: String){
    val botName = _name
    val year = _year
    lateinit var userName: String
    var userAge: Int = 0

    fun printHelloMenu() {
        println("Hello! My name is $botName.")
        println("I was created in $year.")
        print("Please, remind me your name.\n>")
        userName = readLine().toString()
        println("What a great name you have, $userName!")
    }

    fun isNumber(number: String) : Boolean{
        return try{
            number.toInt()
            true
        } catch (e: NumberFormatException){
            println("You inputted wrong value!\nTry again!")
            false
        }
    }

    fun guessAge(){
        println("Enter remainders of dividing your age by 3, 5 and 7.")
        var remainder3: String
        var remainder5: String
        var remainder7: String

        do{
            print(">")
            remainder3 = readLine().toString()
        } while (!isNumber(remainder3))

        do{
            print(">")
            remainder5 = readLine().toString()
        } while (!isNumber(remainder5))

        do{
            print(">")
            remainder7 = readLine().toString()
        } while (!isNumber(remainder7))

        val age = ((remainder3.toInt() * 70) + (remainder5.toInt() * 21) + (remainder7.toInt() * 15)) % 105

        println("Your age is $age; that's a good time to start programming!")
    }

    fun counting(){
        println("Now I will prove to you that I can count to any number you want.")

        var count: String
        do{
            print(">")
            count = readLine().toString()
        } while (!isNumber(count))

        for(i in 1..count.toInt()){
            println("$i!")
        }
    }
}
