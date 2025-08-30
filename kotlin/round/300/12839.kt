import kotlin.math.min

fun main() {
    val (numberOfBoxes, numberOfColors) = readln().split(" ").map { it.toInt() }
    val boxes = List(numberOfBoxes) {
        readln().split(" ").map { it.toInt() }
    }
    val sum = boxes.reduce { acc, box -> acc.zip(box).map { it.first + it.second } }
    val cost = boxes.map { box -> box.mapIndexed { color, current -> sum[color] - current } }
    val dp = List(numberOfBoxes) { MutableList(1 shl numberOfColors) { Int.MAX_VALUE } }

    fun calc(box: Int, mask: Int, move: Int): Int {
        if (mask + 1 == 1 shl numberOfColors) {
            return 0
        }
        if (numberOfColors - move + box > numberOfBoxes) {
            return Int.MAX_VALUE
        }
        if (dp[box][mask] != Int.MAX_VALUE) {
            return dp[box][mask]
        }
        dp[box][mask] = calc(box + 1, mask, move)
        for (i in 0 until numberOfColors) {
            if (mask and (1 shl i) != 0) {
                continue
            }
            dp[box][mask] = min(dp[box][mask], calc(box + 1, mask or (1 shl i), move + 1) + cost[box][i])
        }
        return dp[box][mask]
    }

    println(calc(0, 0, 0))
}
