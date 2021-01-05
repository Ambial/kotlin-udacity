import java.lang.Math.random
import java.util.*

fun main(args: Array<String>) {
    println("Good ${if (args[0].toInt() <12) "morning" else "evening"} Kotlin!")
    //println(dayOfWeek())

/*    var fortune: String
    for (i in 1..10) {
        fortune = getFortuneCookie(getBirthdayInput())
        println("\nYour fortune is: $fortune")
        if (fortune.contains("Take it easy")) break
    }*/

/*    println(canAddFish(10.0, listOf(3,3,3)))
    println(canAddFish(8.0, listOf(2,2,2), hasDecorations = false))
    println(canAddFish(9.0, listOf(1,1,3), 3.0))
    println(canAddFish(10.0, listOf(), 7.0, true))*/

    println(whatShouldIDoToday("happy"))
    println(whatShouldIDoToday("happy", temperature = 39))

    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )

    println(spices.filter { it.toLowerCase().contains("curry") }.sortedBy { s: String -> s.length })

    println(spices.filter { s: String -> s.startsWith('c') && s.endsWith('e') })

    println(spices.filterIndexed { index, s -> index in 0..2 && s.startsWith('c') })

    println(spices.take(3).filter{it.startsWith('c')})

    val random1 = random()
    val random2 = {random()}

    println(random1)
    println(random2)

}

fun whatShouldIDoToday(mood:String, weather:String="Sunny", temperature:Int=24):String {
    return when{
        isHotOutside(temperature) -> "go swimming"
        mood == "happy" && weather == "Sunny" -> "go outside"
        mood == "sad" && weather == "rainy" && temperature == 0 -> "stay in bed"

        else -> "Stay home and read."
    }
}

fun isHotOutside(temperature:Int) = temperature > 30

fun getFortuneCookie(birthday :Int) :String {
    val manyFortunesWow = mutableListOf(
            "You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune."
    )

    return when(birthday) {
        28 or 31 -> manyFortunesWow[0]
        in 1..7 -> manyFortunesWow[1]
        else -> {
            manyFortunesWow[birthday % manyFortunesWow.size]
        }
    }
}

fun getBirthdayInput() :Int {
    print("Enter your day of birth:")
    return readLine()?.toIntOrNull() ?: 1
}

fun dayOfWeek(): String {
    val today = when(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> {
            "Error"
        }
    }
    return "Today is $today"
}

fun canAddFish (tankSize: Double, currentFish:List<Int>, fishSize: Double = 2.0, hasDecorations: Boolean = true ): Boolean{
    //1:1 gallons / inches of fish, 0.8/1 with decorations
    val decoFactor = if (hasDecorations) 0.8f else 1.0f
    return ((currentFish.sum().toDouble() + fishSize)/tankSize <= 1*decoFactor)
}

/* reference
fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}*/
