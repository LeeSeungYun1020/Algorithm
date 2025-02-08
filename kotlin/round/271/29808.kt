fun main() {
    runCatching {
        val number = readNumber()
        buildSet<Pair<Int, Int>> {
            for (i in 0..200) {
                (number - i * 508).let { t ->
                    t.calcScore(305)?.let { add(i to it) }
                    t.calcScore(212)?.let { add(i to it) }
                }
                (number - i * 108).let { t ->
                    t.calcScore(305)?.let { add(i to it) }
                    t.calcScore(212)?.let { add(i to it) }
                }
            }
        }

    }.onSuccess {
        println(it.size)
        println(it.joinToString(separator = "\n") { "${it.first} ${it.second}" })
    }.onFailure { println(0) }
}

fun readNumber(): Int {
    val value = readln().toInt()
    check(value % 4763 == 0)
    return value / 4763
}

fun Int.calcScore(standard: Int): Int? {
    return if (this % standard == 0 && this / standard in 0..200) this / standard else null
}