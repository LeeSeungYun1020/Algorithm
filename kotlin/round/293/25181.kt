fun main() {
    readln()
    val numbers = readln().split(" ").map { it.toInt() }
    val counter = numbers.groupingBy { it }.eachCount()
    if (counter.maxOf { it.value } * 2 > numbers.size) {
        println(-1)
        return
    }
    generate(numbers, counter).joinToString(separator = " ").run { println(this) }
}

fun generate(origin: List<Int>, count: Map<Int, Int>): List<Int> {
    val mutableCount = count.toMutableMap()
    val result = origin.toMutableList()

    fun dfs(level: Int): Boolean {
        if (level == result.size) return true
        mutableCount.entries
            .sortedByDescending { it.value }
            .filter { (key, value) -> value > 0 && key != origin[level] }
            .forEach { (key, value) ->
                result[level] = key
                mutableCount[key] = value - 1
                if (dfs(level + 1)) return true
                mutableCount[key] = value
            }
        result[level] = origin[level]
        return false
    }
    dfs(0)
    return result
}
