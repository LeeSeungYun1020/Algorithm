import kotlin.math.min

fun main() {
    readln()
    val input = readln()
    val (d, m) = readln().split(" ").map { it.toInt() }

    var energy = 0
    var count = 0
    var hCount = 0
    var yCount = 0
    var uCount = 0

    fun delete() {
        energy += min(d * count, d + m)
        count = 0
    }

    input.forEach { c ->
        when (c) {
            'H' -> {
                delete()
                hCount++
            }

            'Y' -> {
                delete()
                yCount++
            }

            'U' -> {
                delete()
                uCount++
            }

            else -> {
                count++
            }
        }
    }
    if (count != 0) delete()
    count = minOf(hCount, yCount, uCount)

    println(if (energy == 0) "Nalmeok" else energy)
    println(if (count == 0) "I love HanYang University" else count)
}