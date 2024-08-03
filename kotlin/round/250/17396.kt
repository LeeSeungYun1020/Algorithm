import java.util.*

fun main() {
    val (numberOfBranch, numberOfRoad) = readln().split(" ").map { it.toInt() }

    var count = 0
    val visibility = readln().split(" ").mapIndexed { index, it ->
        when {
            it == "0" -> count++
            index == numberOfBranch - 1 -> count++
            else -> -1
        }
    }

    val branchMap = List(count) { mutableListOf<Pair<Int, Int>>() }
    repeat(numberOfRoad) {
        val (p1, p2, time) = readln().split(" ").map { it.toInt() }
        val start = visibility[p1]
        val end = visibility[p2]
        if (start != -1 && end != -1) {
            branchMap[start].add(end to time)
            branchMap[end].add(start to time)
        }
    }

    val distanceList = MutableList(branchMap.size) { Long.MAX_VALUE }
    distanceList[0] = 0
    val pq = PriorityQueue<Pair<Int, Long>> { a, b -> a.second.compareTo(b.second) }
    pq.add(0 to 0)
    while (pq.isNotEmpty()) {
        val (now, distance) = pq.poll()
        if (distanceList[now] >= distance) {
            for ((target, time) in branchMap[now]) {
                val nDistance = distance + time
                if (nDistance < distanceList[target]) {
                    distanceList[target] = nDistance
                    pq.add(target to nDistance)
                }
            }
        }
    }
    println(
        when (val it = distanceList.last()) {
            Long.MAX_VALUE -> -1
            else -> it
        }
    )
}