fun main() {
    val (numberOfBuilding, numberOfRoad) = readln().split(" ").map { it.toInt() }
    val roads = List(numberOfRoad) {
        readln().toRoad()
    }.sortedBy { it.cost }
    val group = MutableList(numberOfBuilding) { it }

    fun find(target: Int): Int {
        if (group[target] == target)
            return target
        group[target] = find(group[target])
        return group[target]
    }

    fun merge(a: Int, b: Int) {
        val aRoot = find(group[a])
        val bRoot = find(group[b])
        if (aRoot != bRoot) {
            group[aRoot] = group[bRoot]
        }
    }

    var improved = 0L
    var original = 0L
    var numberOfConnectedRoad = 0
    for ((start, end, cost) in roads) {
        original += cost
        if (find(start) != find(end)) {
            merge(start, end)
            improved += cost
            numberOfConnectedRoad++
        }
    }
    if (numberOfConnectedRoad == numberOfBuilding - 1)
        println(original - improved)
    else
        println(-1)
}

data class Road(val start: Int, val end: Int, val cost: Int)

fun String.toRoad() = this.split(" ").map { it.toInt() }.let { Road(it[0] - 1, it[1] - 1, it[2]) }
