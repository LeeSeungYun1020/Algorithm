fun main() {
    val (_, numberOfCondition) = readln().split(" ").map { it.toInt() }
    val availability = readln().split(" ").map { it.toLong() }.sortedDescending().toCollection(
        ArrayDeque()
    )
    val conditions = List(numberOfCondition) { readln().split(" ").map { it.toLong() }.toCondition() }

    var currentQuality = 0L
    for (condition in conditions) {
        while (availability.isNotEmpty()) {
            if (condition.quality <= currentQuality) {
                break
            }
            currentQuality += (availability.removeFirst() + condition.day)
        }

        if (condition.quality > currentQuality) {
            println(-1)
            return
        }
    }

    println(currentQuality + availability.sum() + conditions.last().day * availability.count())
}

class Condition(val day: Long, val quality: Long)

fun List<Long>.toCondition() = Condition(get(0), get(1))