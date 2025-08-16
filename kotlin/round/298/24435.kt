import kotlin.math.min

fun main() {
    repeat(readln().toInt()) {
        readln()
        val bob = readln().map { it.digitToInt() }.run {
            min(reversed().reduce { a, b -> a * 10 + b }, reduce { a, b -> a * 10 + b })
        }
        val alice = readln().map { it.digitToInt() }.sortedDescending()

        var mx = 0
        fun dfs(level: Int, value: Int, used: Int) {
            if (mx < value) {
                mx = value
            }
            if (level == alice.size) {
                return
            }
            for (i in alice.indices) {
                if (used and (1 shl i) != 0) continue
                val candidate = value * 10 + alice[i]
                if (candidate < bob) {
                    dfs(level + 1, candidate, used or (1 shl i))
                }
            }
        }
        dfs(0, 0, 0)
        println(mx)
    }
}