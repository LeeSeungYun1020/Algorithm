import java.util.*
import kotlin.math.floor
import kotlin.math.sqrt

fun main() {
    val (numberOfStations, numberOfConnections) = readln().split(" ").map { it.toInt() }
    val limit = readln().toDouble()
    val stations = List(numberOfStations) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        x to y
    }

    val distances = List(numberOfStations) {
        MutableList(numberOfStations) { Double.MAX_VALUE }
    }

    repeat(numberOfConnections) {
        val (a, b) = readln().split(" ").map { it.toInt() - 1 }
        distances[a][b] = 0.0
        distances[b][a] = 0.0
    }

    for (i in 0 until numberOfStations - 1) {
        for (j in i + 1 until numberOfStations) {
            if (distances[i][j] == Double.MAX_VALUE) {
                val distance = distance(stations[i], stations[j])
                if (distance <= limit) {
                    distances[i][j] = distance
                    distances[j][i] = distance
                }
            }
        }
    }

    val mn = findMinDistance(numberOfStations, distances)
    println(floor(mn * 1000).toInt())
}

fun distance(a: Pair<Int, Int>, b: Pair<Int, Int>): Double {
    val dx = a.first.toDouble() - b.first
    val dy = a.second.toDouble() - b.second
    return sqrt((dx * dx + dy * dy))
}

fun findMinDistance(n: Int, distanceMap: List<List<Double>>): Double {
    val distances = MutableList(n) { Double.MAX_VALUE }
    distances[0] = 0.0
    val pq = PriorityQueue<Pair<Int, Double>> { a, b -> a.second.compareTo(b.second) }
    pq.add(0 to 0.0)
    while (pq.isNotEmpty()) {
        val (now, distance) = pq.poll()
        for (target in 0 until n) {
            if (now == target || distanceMap[now][target] == Double.MAX_VALUE) continue
            val nDistance = distance + distanceMap[now][target]
            if (nDistance < distances[target]) {
                distances[target] = nDistance
                pq.add(target to nDistance)
            }
        }
    }
    return distances.last()
}