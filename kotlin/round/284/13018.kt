fun main() {
    val (length, numberOfConditions) = readln().split(" ").map { it.toInt() }
    if (length == numberOfConditions) println("Impossible")
    else {
        // 만족하려면 제자리, 1을 어디에 끼워 넣을 것인가?
        (2..length)
            .toMutableList()
            .apply { add(size - numberOfConditions, 1) }
            .joinToString(separator = " ")
            .run { println(this) }
    }
}