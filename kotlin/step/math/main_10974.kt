fun main() {
    val n = readLine()!!.toInt()
    val list = MutableList(n) { it + 1 }

    fun next(): Boolean {
        var i = n - 1
        while (i > 0 && list[i - 1] >= list[i])
            i -= 1
        if (i <= 0) {
            return false
        }

        var j = n - 1
        while (j >= 0 && list[i-1] > list[j])
            j -= 1

        val tem = list[i-1]
        list[i-1] = list[j]
        list[j] = tem

        j = n - 1
        while (i < j) {
            val tem = list[i]
            list[i] = list[j]
            list[j] = tem
            i += 1
            j -= 1
        }
        println(list.joinToString(" "))
        return true
    }

    println(list.joinToString(" "))
    while (next()) {}
}