enum class OddOrEven {
    ODD, EVEN;
}

fun Int.toOddOrEven() = if (this % 2 == 0) OddOrEven.EVEN else OddOrEven.ODD

data class Position(val x: Int, val y: Int) {
    private val xOddOrEven = x.toOddOrEven()
    private val yOddOrEven = y.toOddOrEven()

    fun canNormallyMoveTo(other: Position) =
        (this.xOddOrEven == other.xOddOrEven && this.yOddOrEven == other.yOddOrEven) ||
                (this.xOddOrEven != other.xOddOrEven && this.yOddOrEven != other.yOddOrEven)
}

fun List<Int>.toPosition() = Position(this[0], this[1])

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val start = readln().split(" ").map { it.toInt() }.toPosition()
    val end = readln().split(" ").map { it.toInt() }.toPosition()

    println(
        when {
            start == end -> "YES"
            n == 1 || m == 1 -> "NO"
            start.canNormallyMoveTo(end) -> "YES"
            else -> "NO"
        }
    )
}