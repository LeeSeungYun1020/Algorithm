fun main() {
    val cases = List(readln().toInt()) { readln().split(" ").map { it.toInt() }.sorted() }.distinct()

    fun find(dice: Dice, step: Int): Boolean {
        if (step >= cases.size) {
            return true
        }
        return dice.possibleCases(cases[step]).any {
            find(it, step + 1)
        }
    }

    if (find(Dice(cases[0]), 1)) {
        println("Hmm...")
    } else {
        println("You're gonna die!")
    }
}

fun List<Int>.permutations(): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val visited = MutableList(size) { false }
    fun build(list: MutableList<Int>) {
        if (list.size == size) {
            result.add(list.toList())
            return
        }
        for (i in indices) {
            if (!visited[i]) {
                visited[i] = true
                list.add(get(i))
                build(list)
                list.removeLast()
                visited[i] = false
            }
        }
    }
    build(mutableListOf())
    return result
}

class Dice(
    numbers: List<Int>,
) {
    private val numbers: MutableList<Int> = MutableList(8) { numbers.getOrElse(it) { 0 } }

    fun possibleCases(list: List<Int>): List<Dice> {
        return list.permutations().map { (a, b, c, d) ->
            listOf(
                listOf(0, 1, 2, 3),
                listOf(1, 0, 4, 5),
                listOf(2, 0, 4, 6),
                listOf(3, 0, 5, 6),
                listOf(4, 1, 2, 7),
                listOf(5, 1, 3, 7),
                listOf(6, 2, 3, 7),
                listOf(7, 4, 5, 6),
            ).map { construct(listOf(it[0] to a, it[1] to b, it[2] to c, it[3] to d)) }
                .filter { it.isSuccess }
                .map { it.getOrThrow() }
        }.flatten()
    }

    private fun construct(data: List<Pair<Int, Int>>): Result<Dice> = runCatching {
        Dice(numbers).apply {
            data.forEach {
                when (numbers[it.first]) {
                    it.second -> {}
                    0 -> { // 신규
                        check(it.second !in numbers)
                        numbers[it.first] = it.second
                    }
                    else -> throw IllegalStateException("Impossible")
                }
            }
        }
    }
}
