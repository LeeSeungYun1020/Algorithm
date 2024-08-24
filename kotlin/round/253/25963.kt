import kotlin.math.absoluteValue

const val MX = 100_000

fun main() {
    val n = readln().toInt()
    val blocks = readln().split(" ").map(String::toInt)
    val numberOfBlocks = blocks.sum()

    val dp = List(n - 1) { // pos
        List(n + 1) { // height
            MutableList(numberOfBlocks + 1) { // used
                -1
            }
        }
    }

    fun find(pos: Int, height: Int, used: Int): Int {
        return when {
            pos == n - 1 -> {
                if (used + height == numberOfBlocks) (height - blocks[pos]).absoluteValue
                else MX
            }
            height !in dp[pos].indices || used !in dp[pos][height].indices -> MX
            dp[pos][height][used] >= 0 -> dp[pos][height][used]
            else -> {
                dp[pos][height][used] = minOf(
                    find(pos + 1, height - 1, used + height),
                    find(pos + 1, height, used + height),
                    find(pos + 1, height + 1, used + height)
                ) + (height - blocks[pos]).absoluteValue
                dp[pos][height][used]
            }
        }
    }

    println((1..n).minOf {
        find(0, it, 0)
    } / 2)
}