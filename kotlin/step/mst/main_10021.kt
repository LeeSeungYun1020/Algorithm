fun calcDistance(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Int {
    if (p1 == p2) return Int.MAX_VALUE
    return (p1.first - p2.first) * (p1.first - p2.first) + (p1.second - p2.second) * (p1.second - p2.second)
}

fun Array<Int>.minIndex(least: Int = 0): Int {
    var min = first()
    var minIndex = -1
    forEachIndexed { index, item ->
        if (item in least until min) {
            min = item
            minIndex = index
        }
    }
    if (min == Int.MAX_VALUE) return -1
    return minIndex
}

fun main() {
    val (N, C) = readLine()!!.split(" ").map { it.toInt() }
    val point = Array<Pair<Int, Int>>(N) { 0 to 0 }

    for (i in 0 until N) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        point[i] = x to y
    }

    val distance = Array(N) {
        calcDistance(point[0], point[it]).takeIf { it >= C }?: Int.MAX_VALUE
    }
    val visited = Array(N) { false }
    var cost = 0

    visited[0] = true
    while (visited.any { it == false }) {
        val i = distance.minIndex(C)
        if (i == -1) {
            println(-1)
            return
        }
        visited[i] = true
        cost += distance[i]
        for (j in 1 until N) {
            if (visited[j])
                distance[j] = Int.MAX_VALUE
            else {
                val d = calcDistance(point[i], point[j])
                if (d >= C && distance[j] > d)
                    distance[j] = d
            }
        }
    }
    println(cost)
}