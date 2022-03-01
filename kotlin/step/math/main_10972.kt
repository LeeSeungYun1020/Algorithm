fun main() {
    val n = readLine()!!.toInt()
    val list = readLine()!!.split(" ").map { it.toInt() }.toMutableList()

    var i = n - 1
    while (i > 0 && list[i - 1] >= list[i]) // < 인 조건 찾기
        i -= 1
    if (i <= 0) { // 마지막 순열인 경우
        println(-1)
        return
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
}