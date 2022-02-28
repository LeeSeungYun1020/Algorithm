fun main() {
    val n = readLine()!!.toInt()
    val compare = readLine()!!.map {
        when (it) {
            '-' -> { a: Int -> a < 0 }
            '+' -> { a: Int -> a > 0 }
            else -> { a: Int -> a == 0 }
        }
    }

    val number = MutableList(n) { 0 }
    fun count(start: Int, end: Int): Int {
        var sum = 0
        for (i in start..end) {
           sum += number[i]
        }
        return sum
    }

    fun validate(limit: Int): Boolean {
        var idx = 0
        for (i in 0 .. limit) {
            for (j in i .. limit) {
                if (!compare[idx](count(i, j)))
                    return false
                idx++
            }
            idx += n - limit - 1
        }
        return true
    }

    var find = false
    fun dfs(level: Int) {
        if (find) return
        if (level == n) {
            println(number.joinToString(" "))
            find = true
            return
        }
        for (i in -10..10) {
            number[level] = i
            if (validate(level)) {
                dfs(level + 1)
            }
        }
    }

    dfs(0)
}