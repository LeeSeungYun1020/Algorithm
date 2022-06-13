import kotlin.math.max

fun main() {
    val n = readln().toInt()
    var width = 0
    var height = 0
    val length = List(6) { i ->
        val num = readln().split(" ").last().toInt()
        if (i % 2 == 0)
            width = max(width, num)
        else
            height = max(height, num)
        num
    }

    var wIn = 0
    var hIn = 0
    for (i in 0 until 6) {
        if (i % 2 == 1 && length[(i+5) % 6] + length[(i+1) % 6] == width)
            hIn = length[i]
        if (i % 2 == 0 && length[(i+5) % 6] + length[(i+1) % 6] == height)
            wIn = length[i]
    }
    println((width * height - wIn * hIn) * n)
}