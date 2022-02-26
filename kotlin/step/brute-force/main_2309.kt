fun main() {
    val number = List(9) { readLine()!!.toInt() }
    val sum = number.sum()
    for (i in 0 until 8) {
        for (j in i + 1 until 9) {
            if (sum - number[i] - number[j] == 100) {
                number.filterIndexed { index, _ -> index != i && index != j }.sorted().forEach {
                    println(it)
                }
                return
            }
        }
    }
}