fun main() {
    println(buildString {
        repeat(readln().toInt()) {
            val (_, k) = readln().split(" ")
            val runList = k.toLong().toRunList()
            append("${runList.size}\n")
            append("${runList.joinToString(separator = " ")}\n")
        }
    })
}

fun Long.toRunList(): List<Long> = buildList {
    var calc = this@toRunList
    while (calc.toString().length > 1) {
        val mx = calc.takeMax()
        add(mx)
        calc -= mx
    }
    if (calc != 0L) {
        add(calc)
    }
}

fun Long.takeMax(): Long {
    val numberString = toString()
    return (numberString.length downTo 1).mapIndexed { i, d -> d to if (i == 0) numberString.first().digitToInt() else 9 }.firstNotNullOf { (digit, n) ->
        (n downTo 1).map { findGreedyRun(it, digit) }.firstOrNull { target -> target <= this }
    }
}

fun findGreedyRun(num: Int, len: Int): Long {
    return num.toString().repeat(len).toLong()
}