fun main() {
    val k = readLine()!!.toInt()
    val compare = readLine()!!.split(" ").map {
        if (it[0] == '<')
            { a: Int, b: Int -> a < b }
        else
            { a: Int, b: Int -> a > b }
    }

    val number = MutableList(k + 1) { 0 }
    val selected = MutableList(10) { false }
    fun validate(): Boolean {
        for (i in 0 until k) {
            if (!compare[i](number[i], number[i + 1]))
                return false
        }
        return true
    }

    var reversed = true
    var find = false
    fun dfs(level: Int) {
        if (find) return
        if (level == k + 1) {
            if (validate()) {
                println(number.joinToString(""))
                find = true
            }
            return
        }
        val range = if (reversed) 9 downTo 0 else 0..9
        for (i in range) {
            if (!selected[i]) {
                number[level] = i
                selected[i] = true
                dfs(level + 1)
                selected[i] = false
            }
        }
    }

    dfs(0)
    find = false
    reversed = false
    dfs(0)
}