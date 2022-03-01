fun main() {
    while (true) {
        val input = readLine()!!.split(" ").map { it.toInt() }
        val n = input.first()
        if (n == 0) return

        val list = MutableList(6) { 0 }
        val selected = MutableList(n + 1) { false }
        fun dfs(level: Int) {
            if (level == 6) {
                println(list.map { input[it] }.joinToString(" "))
                return
            }
            val first = list.getOrElse(level - 1) { 1 }
            for (i in first .. n) {
                if (!selected[i]) {
                    selected[i] = true
                    list[level] = i
                    dfs(level + 1)
                    selected[i] = false
                }
            }
        }
        dfs(0)
        println()
    }
}