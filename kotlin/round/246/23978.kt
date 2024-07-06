import kotlin.math.min

fun main() {
    val (_, need) = readln().split(" ").map { it.toLong() }
    val days = readln().split(" ").map { it.toLong() }

    fun sum(x: Long): Long {
        val inc = x * (x + 1) / 2
        val dec = days.windowed(2).sumOf {
            val h = min(it[1] - it[0], x) - 1
            x * (h + 1) - h * (h + 1) / 2
        }
        return inc + dec
    }

    var mx = 1500000000L
    var mn = 1L
    var ans = mx

    while (mx >= mn) {
        val target = (mx + mn) / 2

        if (sum(target) >= need) {
            ans = min(ans, target)
            mx = target - 1
        } else {
            mn = target + 1
        }
    }
    println(ans)
}