fun main() {
    val n = readLine()!!.toInt()
    val list = List(n) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        a to b
    }.sortedBy { it.first }.map { it.second }
    val ans = mutableListOf(list[0])
    list.forEach { value ->
        if (ans.last() < value)
            ans.add(value)
        else {
            var start = 0
            var end = ans.lastIndex
            while (start <= end) {
                val mid = (start + end) / 2
                if (ans[mid] < value)
                    start = mid + 1
                else
                    end = mid - 1
            }
            ans[start] = value
        }

    }
    println(n - ans.size)
}