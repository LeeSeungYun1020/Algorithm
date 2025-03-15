import java.util.*

fun main() {
    val queue = PriorityQueue<Duration>()
    var maxCount = 0
    var answer = Date("2000-00")
    List(readln().toInt()) { readln().toDuration() }.sortedBy { it.start }.forEach { current ->
        while (queue.peek() != null && current.start > queue.peek().end) queue.poll()
        queue.add(current)
        if (maxCount < queue.size) {
            maxCount = queue.size
            answer = current.start
        }
    }
    println(answer)
}

class Duration(val start: Date, val end: Date) : Comparable<Duration> {
    override fun compareTo(other: Duration): Int = end.compareTo(other.end)
}

class Date(date: String) : Comparable<Date> {
    private val number: Int = date.replace("-", "").toInt()

    override fun toString(): String = "%04d-%02d".format(number / 100, number % 100)

    override fun compareTo(other: Date): Int = number.compareTo(other.number)
}

fun String.toDuration() = split(" ").let { Duration(Date(it[0]), Date(it[1])) }