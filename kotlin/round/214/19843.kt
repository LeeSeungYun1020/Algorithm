fun main() {
    val (time, number) = readln().split(" ").map { it.toInt() }
    var sleep = 0
    repeat(number) {
        val (startDayString, startTimeString, endDayString, endTimeStirng) = readln().split(" ")
        val start = startDayString.dayToTime() + startTimeString.toInt()
        val end = endDayString.dayToTime() + endTimeStirng.toInt()
        sleep += (end - start)
    }
    val diff = (time - sleep)
    when {
        diff <= 0 -> println(0)
        diff > 48 -> println(-1)
        else -> println(diff)
    }

}

fun String.dayToTime() = when (this) {
    "Mon" -> 0
    "Tue" -> 24
    "Wed" -> 24 * 2
    "Thu" -> 24 * 3
    "Fri" -> 24 * 4
    else -> throw Exception()
}