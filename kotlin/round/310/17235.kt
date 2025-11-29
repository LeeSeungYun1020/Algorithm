import java.math.BigInteger
import kotlin.math.max

fun main() {
    val points = List(readln().toInt()) { readln().split(" ").map { it.toLong() } }
    max(
        points.map { -it[0] + it[1] }.sorted().let { it.last() - it.first() },
        points.map { it[0] + it[1] }.sorted().let { it.last() - it.first() }
    ).let {
        val calc = (BigInteger.valueOf(it) * BigInteger.valueOf(it) / BigInteger.TWO).toString()
        if (it % 2 == 1L) { "$calc.5" } else calc
    }.run(::println)
}