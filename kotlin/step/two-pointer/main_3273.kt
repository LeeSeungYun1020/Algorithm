fun main() {
    val n = readln().toInt()
    val number = readln().split(" ").map { it.toInt() }.sorted()
    val x = readln().toInt()
    var count = 0
    for (i in 0 until n)
        for (j in i + 1 until n)
            if (number[i] + number[j] == x)
                count++
            else if (number[i] + number[j] > x)
                break
    println(count)
}