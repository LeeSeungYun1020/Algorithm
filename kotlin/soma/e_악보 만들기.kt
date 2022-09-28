fun main() {
    val (N, X, K) = readLine()!!.split(" ").map { it.toInt() }
    val A = readLine()!!.split(" ").map { it.toInt() } // 0 쉼표

    fun isBreakable(start: Int, end: Int): Boolean {
        for (i in end downTo end - K + 1) {
            if (i < 0) return false
            if (i < start) return false
            if (A[i] == 1) return false
        }
        return true
    }

    var page = 0
    var pos = 0
    while (pos < N) {
        if (N - pos <= X) {
            page++
            break
        }
        var isSuccess = false
        for (i in pos + X - 1 downTo pos) {
            if (isBreakable(pos, i)) {
                page++
                pos = i + 1
                isSuccess = true
                break
            }
        }
        if (!isSuccess) {
            println(-1)
            return
        }
    }
    println(page)
}