import kotlin.math.absoluteValue

fun main() {
    val (hour, minute) = readln().split(":").map { it.toInt() }
    val (targetHour, targetMinute) = readln().split(":").map { it.toInt() }
    val current = hour * 60 + minute
    listOf(targetHour, targetHour - 12, targetHour + 12).minOf {
        (current - (it * 60 + targetMinute)).absoluteValue
    }.let { println(it * 6) }
}