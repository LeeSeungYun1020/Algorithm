fun main() {
    repeat(readln().toInt()) {
        println(Board(List(readln().toInt()) { readln() }).mine)
    }
}

class Board(list: List<String>) {
    private val board = list

    val mine
        get(): Int = when {
            board.size < 3 -> 0
            board.size == 3 -> board.first().first().digitToInt()
            else -> left + right + bottom + top - edge + center
        }

    private val left get() = board.map { it.first().digitToInt() }.calc()
    private val right get() = board.map { it.last().digitToInt() }.calc()
    private val top get() = board.first().map { it.digitToInt() }.calc()
    private val bottom get() = board.last().map { it.digitToInt() }.calc()
    private val center get() = (board.size - 4) * (board.size - 4)
    private val edge
        get() = board.first().first().digitToInt() + board.first().last().digitToInt() + board.last().first()
            .digitToInt() + board.last().last().digitToInt()

    private fun List<Int>.calc(): Int {
        val result = MutableList(size - 2) { 0 }
        for (i in result.indices) {
            result[i] = this[i] - result.getOrElse(i - 2) { 0 } - result.getOrElse(i - 1) { 0 }
        }
        return result.sum()
    }
}

