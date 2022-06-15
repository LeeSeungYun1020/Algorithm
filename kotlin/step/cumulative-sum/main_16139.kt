fun main() {
    val str = readln()
    val strMapList = MutableList(str.length) { mutableMapOf<Char, Int>() }
    strMapList[0] = mutableMapOf(str[0] to 1)
    for (i in 1..str.lastIndex) {
        strMapList[i] = strMapList[i-1].toMutableMap()
        strMapList[i][str[i]] = strMapList[i-1].getOrDefault(str[i], 0) + 1
    }

    val n = readln().toInt()
    for (i in 1..n) {
        val (alpha, start, end) = readln().split(" ")
        if (start.toInt() == 0)
            println(strMapList[end.toInt()].getOrDefault(alpha[0], 0))
        else
            println(strMapList[end.toInt()].getOrDefault(alpha[0], 0) - strMapList[start.toInt() - 1].getOrDefault(alpha[0], 0))
    }
}