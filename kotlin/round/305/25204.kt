import kotlin.math.max

fun main() {
    List(readln().toInt()) {
        List(readln().toInt()) { readln() }.sortedWith(::compare).joinToString(separator = "\n")
    }.joinToString(separator = "\n").run(::println)
}

fun compare(a: String, b: String): Int {
    for (i in 0..max(a.lastIndex, b.lastIndex)) {
        if (i > a.lastIndex) return -1
        if (i > b.lastIndex) return 1
        if (a[i] == b[i]) continue
        if (a[i] == '-') return 1
        if (b[i] == '-') return -1
        if (a[i].equals(b[i], ignoreCase = true)) return a[i].code - b[i].code
        return a[i].lowercaseChar().code - b[i].lowercaseChar().code
    }
    return 0
}