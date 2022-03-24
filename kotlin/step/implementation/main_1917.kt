fun resize(input: List<List<Boolean>>): List<List<Boolean>> {
    val top = input.indexOfFirst { it.contains(true) }
    val bottom = input.indexOfLast { it.contains(true) }
    val start = input.minOf {
        val idx = it.indexOfFirst { it == true }
        if (idx == -1)
            Int.MAX_VALUE
        else
            idx
    }
    val end = input.maxOf { it.indexOfLast { it == true } }
    return input.slice(top..bottom).map { it.slice(start..end) }
}

val basic = mutableListOf(
    listOf(
        listOf(true, false, false, false),
        listOf(true, true, true, true),
        listOf(true, false, false, false),
    ),
    listOf(
        listOf(true, false, false, false),
        listOf(true, true, true, true),
        listOf(false, true, false, false),
    ),
    listOf(
        listOf(true, false, false, false),
        listOf(true, true, true, true),
        listOf(false, false, true, false),
    ),
    listOf(
        listOf(true, false, false, false),
        listOf(true, true, true, true),
        listOf(false, false, false, true),
    ),
    listOf(
        listOf(false, true, false, false),
        listOf(true, true, true, true),
        listOf(false, true, false, false),
    ),
    listOf(
        listOf(false, true, false, false),
        listOf(true, true, true, true),
        listOf(false, false, true, false),
    ),
    listOf(
        listOf(false, false, true, true),
        listOf(true, true, true, false),
        listOf(true, false, false, false),
    ),
    listOf(
        listOf(false, false, true, true),
        listOf(true, true, true, false),
        listOf(false, true, false, false),
    ),
    listOf(
        listOf(false, false, true, true),
        listOf(true, true, true, false),
        listOf(false, false, true, false),
    ),
    listOf(
        listOf(false, false, true, true, true),
        listOf(true, true, true, false, false)
    ),
    listOf(
        listOf(false, false, true, true),
        listOf(false, true, true, false),
        listOf(true, true, false, false)
    )
)

val allCase = buildList {
    addAll(basic)
    addAll(basic.map { it.flip() })
    val r1 = this.map { it.rotate() }
    val r2 = r1.map { it.rotate() }
    val r3 = r2.map { it.rotate() }
    addAll(r1)
    addAll(r2)
    addAll(r3)
}

fun List<List<Boolean>>.rotate(): List<List<Boolean>> {
    val width = this.size
    val height = this[0].size
    val newShape = List(height) { MutableList(width) { false } }
    for (i in 0 until height) {
        for (j in 0 until width) {
            newShape[i][j] = this[width - 1 - j][i]
        }
    }
    return newShape
}

fun List<List<Boolean>>.flip(): List<List<Boolean>> {
    return this.map { it.reversed() }
}



fun main() {
    val input = List(18) { readln().split(" ").map { it == "1" } }
    for (range in listOf(0 until 6, 6 until 12, 12 until 18)) {
        if (resize(input.slice(range)) in allCase)
            println("yes")
        else
            println("no")
    }

}