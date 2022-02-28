import kotlin.math.absoluteValue
import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    val stat = List(n) { readLine()!!.split(" ").map { it.toInt() } }

    val selected = MutableList(n) { false }
    val team = MutableList(n/2) { 0 }
    var limit = 0
    var ans = 20000
    fun calcStat(): Int {
        val start = team.subList(0, limit)
        val link = (0 until n).filter { it !in start }
        var startStat = 0
        var linkStat = 0
        for (i in start)
            for (j in start)
                if (i != j)
                    startStat += stat[i][j]
        for (i in link)
            for (j in link)
                if (i != j)
                    linkStat += stat[i][j]
        return (startStat - linkStat).absoluteValue
    }

    fun dfs(level: Int) {
        if (level == limit) {
            ans = min(ans, calcStat())
            return
        }
        val start = team.getOrElse(level - 1) { 0 }
        for (i in start until n) {
            if (!selected[i]) {
                team[level] = i
                selected[i] = true

                dfs(level + 1)
                selected[i] = false
            }
        }
    }

    for (i in 1 .. n/2){
        limit = i
        dfs(0)
    }
    println(ans)
}