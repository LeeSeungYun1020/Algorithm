import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val consist = mutableSetOf<Char>()
    val word = List(n) { readln().map {
        consist.add(it)
        it
    } }
    val alpha = consist.size

    val consistMap = mutableMapOf<Char, Int>()
    consist.forEachIndexed { index, c -> consistMap[c] = index }

    val num = MutableList(alpha) { 0 }
    val visited = MutableList(alpha) { false }
    var ans = 0

    fun calcWord(): Int {
        var sum = 0
        for (w in word) {
            var subSum = 0
            for (c in w) {
                subSum = subSum * 10 + num[consistMap[c]!!]
            }
            sum += subSum
        }
        return sum
    }

    fun dfs(level: Int) {
        if (level < 10 - alpha) {
            ans = max(ans, calcWord())
            return
        }

        for (i in 0 until alpha)
            if (!visited[i]) {
                visited[i] = true
                num[i] = level
                dfs(level - 1)
                visited[i] = false
            }
    }

    dfs(9)
    println(ans)
}