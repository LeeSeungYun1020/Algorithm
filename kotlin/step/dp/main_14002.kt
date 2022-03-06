fun main() {
    val n = readln().toInt()
    val num = readln().split(" ").map { it.toInt() }
    val ans = MutableList(n) { emptyList<Int>() }
    ans[0] = listOf(num[0])
    var idx = 0 to 1
    for (i in 1 until n) {
        var mx = i
        for (j in i-1 downTo 0) {
            if (num[j] < num[i] && ans[mx].size < ans[j].size) {
                mx = j
            }
        }
        if (mx == i)
            ans[i] = listOf(num[i])
        else
            ans[i] = ans[mx] + num[i]

        if (ans[i].size > idx.second)
            idx = i to ans[i].size
    }
    val lst = ans[idx.first]
    println(lst.size)
    println(lst.joinToString(" "))
}