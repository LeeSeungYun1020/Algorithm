import kotlin.math.max

fun main() {
    var answer = Triple<Long, Int, Int>(-1L, 0, 0)
    var find = false
    val (a, b) = readln().split(" ")
    val aMinRadix = a.minRadix()
    val aList = (aMinRadix..36).mapNotNull { a.toLongOrNull(it) }
    for (it in b.minRadix()..36) {
        val calc = b.toLongOrNull(it) ?: break
        val aIndex = aList.indexOf(calc)
        if (aIndex != -1 && aIndex + aMinRadix != it) {
            if (find) {
                println("Multiple")
                return
            }
            answer = Triple(calc, aIndex + aMinRadix, it)
            find = true
        }
    }

    println(
        if (find) {
            "${answer.first} ${answer.second} ${answer.third}"
        } else {
            "Impossible"
        }
    )
}

fun String.minRadix() =
    max(2, this.maxOf {
        if (it in '0'..'9') {
            it.digitToInt()
        } else {
            it.code - 'a'.code + 10
        }
    } + 1)
