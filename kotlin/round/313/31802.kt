fun main() {
    val interval = readln().toInt()
    val sum = readln().split(" ").map { it.toLong() }.runningFold(0L) { acc, i -> acc + i }
    val (infimum, supremum) = readln().split(" ").map { it.toLong() }

    if (infimum == supremum) {
        println(0)
        return
    }

    (-Math.floorDiv(infimum, interval.toLong())).let { move ->
        val c = interval * move
        val cSupremum = supremum + c
        val cInfimum = infimum + c
        ((cSupremum) / interval * sum.last()) + (sum[(cSupremum % interval).toInt()]) - (sum[cInfimum.toInt()])
    }.run(::println)
}