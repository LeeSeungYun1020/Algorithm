fun main() {
    val (numberOfCities, numberOfRoads) = readln().split(" ").map { it.toInt() }
    val roadGraph = List(numberOfCities) { MutableList(numberOfCities) { false } }
    repeat(numberOfRoads) {
        readln().split(" ").map { it.toInt() - 1 }.let { (from, to) ->
            roadGraph[from][to] = true
            roadGraph[to][from] = true
        }
    }
    val targetCities = mutableSetOf<Int>()
    val destroyedCityMap = mutableMapOf<Int, Boolean>()
    readln()
    readln().split(" ").map { it.toInt() - 1 }.associateWithTo(destroyedCityMap) { false }.let { destroyedCityMap ->
        destroyedCityMap.keys.forEach { city ->
            roadGraph[city].withIndex()
                .filter { it.value }
                .takeIf { it.all { it.index in destroyedCityMap.keys } }
                ?.forEach { destroyedCityMap[it.index] = true }
                ?.run {
                    destroyedCityMap[city] = true
                    targetCities.add(city)
                }
        }
    }

    if (destroyedCityMap.values.all { it }) {
        println(targetCities.count())
        println(targetCities.joinToString(" ") { (it + 1).toString() })
    } else {
        println(-1)
    }
}