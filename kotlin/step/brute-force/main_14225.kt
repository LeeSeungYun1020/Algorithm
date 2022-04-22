fun main() {
    readln()
    val num = readln().split(" ").map { it.toInt() }
    val sums = mutableSetOf<Int>()
    fun dfs(sum: Int, level: Int) {
        if (num.lastIndex >= level) {
            dfs(sum + num[level], level + 1)
            dfs(sum, level + 1)
        } else {
            sums.add(sum)
        }
    }

    dfs(0, 0)
    for (i in 1..2_000_000) {
        if (i !in sums) {
            println(i)
            break
        }
    }
}