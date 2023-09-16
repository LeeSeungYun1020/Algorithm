fun main() {
    val numberOfWord = readln().toInt()
    val words = List(numberOfWord) { readln() }

    if (numberOfWord == 1) {
        println("four")
        return
    }

    val sum = words.sumOf { it.length } - 1
    for (check in sum..999) {
        val numberString = check.toNumberString()
        if (sum + numberString.length == check) {
            // Find
            println(words.joinToString(separator = " ") {
                if (it == "$")
                    numberString
                else
                    it
            })
            return
        }
    }
}

fun Int.toNumberString(): String {
    return "${hundred(this)}${ten(this)}"
}

fun one(n: Int): String {
    return when (n) {
        0 -> ""
        1 -> "one"
        2 -> "two"
        3 -> "three"
        4 -> "four"
        5 -> "five"
        6 -> "six"
        7 -> "seven"
        8 -> "eight"
        9 -> "nine"
        10 -> "ten"
        else -> throw Exception("Check number")
    }
}

fun oneTen(n: Int): String {
    if (n < 11)
        return one(n)
    return when (n) {
        11 -> "eleven"
        12 -> "twelve"
        13 -> "thirteen"
        14 -> "fourteen"
        15 -> "fifteen"
        16 -> "sixteen"
        17 -> "seventeen"
        18 -> "eighteen"
        19 -> "nineteen"
        else -> throw Exception("Check number")
    }
}

fun ten(n: Int): String {
    val tN = n % 100
    if (tN < 20) {
        return oneTen(tN)
    }
    val t = when (tN / 10) {
        2 -> "twenty"
        3 -> "thirty"
        4 -> "forty"
        5 -> "fifty"
        6 -> "sixty"
        7 -> "seventy"
        8 -> "eighty"
        9 -> "ninety"
        else -> throw Exception("Check number")
    }
    return "$t${one(tN % 10)}"
}

fun hundred(n: Int): String {
    return when (val it = n / 100) {
        0 -> ""
        else -> "${one(it)}hundred"
    }
}