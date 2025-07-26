import kotlin.math.ceil

fun main() {
    readln()
    val prev = readExpression()
    val now = readExpression()
    val pSum = prev.sum()
    if (pSum == 0L) println("0 ${now.sum()}")
    else println("${prev.sum()} ${prev.zip(now).maxOf { ceil(it.first.toDouble() / it.second).toLong() } * now.sum()}")
}

fun readExpression() = readln().split(" ").map { it.toLong() }.run {
    val gcd = gcd(this)
    if (gcd == 0L) this else map { it / gcd }
}

fun gcd(list: List<Long>): Long = list.reduce { a, b -> gcd(a, b) }
tailrec fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)