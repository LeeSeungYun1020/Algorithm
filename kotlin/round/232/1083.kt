import java.util.*
import kotlin.math.min

fun main() {
    readln()
    val list: MutableList<Int> =
        readln().split(" ").map { it.toInt() }.toCollection(LinkedList<Int>())
    var s = readln().toInt()

    var currentIndex = 0
    while (s >= 0 && currentIndex <= list.lastIndex) {
        // 가장 큰 수 탐색
        var mx = list[currentIndex]
        var mxIndex = currentIndex
        for (move in currentIndex + 1..min(currentIndex + s, list.lastIndex)) {
            if (list[move] > mx) {
                mx = list[move]
                mxIndex = move
            }
        }
        // 가장 큰 수 배치
        list.add(currentIndex, list.removeAt(mxIndex))
        s -= (mxIndex - currentIndex)
        currentIndex++
    }
    println(list.joinToString(separator = " "))
}