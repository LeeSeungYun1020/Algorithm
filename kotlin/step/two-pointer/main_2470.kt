import kotlin.math.absoluteValue

fun main() {
    val n = readln().toInt()
    val solution = readln().split(" ").map { it.toLong() }.sorted()

    var ans = Long.MAX_VALUE
    var ansValue = 0L to 0L

    var first = 0
    var last = n-1
    while (first < last) {
        val calc = solution[first] + solution[last]
        val diff = calc.absoluteValue
        if (ans > diff) {
            ans = diff
            ansValue = solution[first] to solution[last]
        }

        if (calc < 0)
            first++
        else if (calc == 0L) {
            println("${solution[first]} ${solution[last]}")
            return
        } else {
            last--
        }
    }

    println("${ansValue.first} ${ansValue.second}")
}