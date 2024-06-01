import java.util.*

fun main() {
    val (_, limit) = readln().split(" ").map { it.toInt() }
    val points = readln().split(" ").map { it.toInt() }.filterNot { it == 0 }

    val priorityQueue = PriorityQueue<Int>(Comparator.reverseOrder())
    var current = 0L
    var count = 0
    points.forEach { point ->
        priorityQueue.add(point)
        current += point

        while (current >= limit) {
            current -= (priorityQueue.remove() * 2)
            count++
        }
    }
    println(count)
}
