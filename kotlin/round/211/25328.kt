fun main() {
    val x = readln()
    val y = readln()
    val z = readln()
    val k = readln().toInt()

    val result = mutableSetOf<String>()
    val xSub = x.makeSubStrings(k)
    val ySub = y.makeSubStrings(k).also {
        result.addAll(xSub intersect it)
    }
    z.makeSubStrings(k).also {
        result.addAll(xSub intersect it)
        result.addAll(ySub intersect it)
    }

    println(
        if (result.size == 0)
            -1
        else
            result.sorted().joinToString(separator = "\n")
    )
}

fun String.makeSubStrings(k: Int): Set<String> {
    val subStrings = mutableSetOf<String>()
    fun dfs(level: Int, selected: List<Int>) {
        if (selected.size == k) {
            subStrings.add(this.toStringWithIndex(selected))
        } else if (level == this.length) {
            return
        } else {
            dfs(level + 1, selected + level)
            dfs(level + 1, selected)
        }
    }
    dfs(0, emptyList())
    return subStrings
}

fun String.toStringWithIndex(index: List<Int>): String {
    val result = mutableListOf<Char>()
    index.forEach { result.add(this[it]) }
    return result.joinToString(separator = "")
}