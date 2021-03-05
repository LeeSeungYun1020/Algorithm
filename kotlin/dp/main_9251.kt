import kotlin.math.max

fun main() {
    val line1 = readLine()!!
    val line2 = readLine()!!
    val array = Array (line1.length + 1) { IntArray(line2.length + 1) }
    for (i in 1..line1.length) {
        for (j in 1..line2.length) {
            if (line1[i - 1] == line2[j - 1])
                array[i][j] = array[i - 1][j - 1] + 1
            else
                array[i][j] = max(array[i][j - 1], array[i - 1][j])
        }
    }
    println(array[line1.length][line2.length])
}