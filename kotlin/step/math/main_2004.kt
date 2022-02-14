import kotlin.math.min

fun main() {
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    val five = countFive(n) - countFive(m) - countFive(n - m)
    val two = countTwo(n) - countTwo(m) - countTwo(n - m)
    println(min(two, five))
}

fun countFive(num: Int): Long{
    var five = 5L
    var ans = 0L
    while (five <= num) {
        ans += (num / five)
        five *= 5
    }
    return ans
}

fun countTwo(num: Int): Long{
    var two = 2L
    var ans = 0L
    while (two <= num) {
        ans += (num / two)
        two *= 2
    }
    return ans
}