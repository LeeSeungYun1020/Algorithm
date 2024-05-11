import kotlin.math.min

fun main() {
    val (_, numberOfCut) = readln().split(" ").map { it.toInt() }
    var cutLeft = numberOfCut
    var count = 0
    readln().split(" ").map { it.toInt() }.sortedBy {
        when {
            it == 10 -> 0
            it % 10 == 0 -> it
            else -> it + 1000
        }
    }.forEach {
        when {
            it == 10 -> count++
            cutLeft == 0 -> return@forEach
            it % 10 == 0 -> {
                val need = it / 10 - 1
                if (need <= cutLeft) {
                    cutLeft -= need
                    count += need + 1
                } else {
                    count += cutLeft
                    cutLeft = 0
                }
            }

            else -> {
                val cut = min(it / 10, cutLeft)
                cutLeft -= cut
                count += cut
            }
        }
    }
    println(count)
}