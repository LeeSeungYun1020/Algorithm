import kotlin.math.absoluteValue

fun main() {
    List(readln().toInt()) {
        readln().split(" ").map { it.toInt() }.let { (x, y, z) ->
            Triple(x, y, z)
        }
    }
        .groupBy {
            if (it.first == 0) return@groupBy 0 to 1 // x = 0 처리
            if (it.second == 0) return@groupBy 1 to 0 // y = 0 처리
            val gcd = gcd(it.first, it.second)
            it.first / gcd to it.second / gcd
        }
        .mapValues {
            if (it.key == 1 to 0) { // y = 0 처리
                return@mapValues it.value.groupBy { it.first > 0 }.entries.flatMap { (isPlus, value) ->
                    (if (isPlus) value.sortedBy { it.first } else value.sortedByDescending { it.first }).filteredRemoved()
                }
            }
            it.value.sortedBy { it.second }.filteredRemoved()
        }
        .flatMap { it.value }
        .sortedWith(compareBy({ it.first }, { it.second }))
        .joinToString("\n") { "${it.first} ${it.second}" }
        .let(::println)
}

fun gcd(a: Int, b: Int): Int {
    val aa = a.absoluteValue
    val bb = b.absoluteValue
    return if (aa > bb) gcdInternal(aa, bb) else gcdInternal(bb, aa)
}

fun gcdInternal(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

fun List<Triple<Int, Int, Int>>.filteredRemoved(): List<Pair<Int, Int>> {
    val filtered = mutableListOf<Pair<Int, Int>>()
    fold(-1) { maxHeight, pos ->
        if (pos.third > maxHeight) {
            pos.third
        } else {
            filtered.add(pos.first to pos.second)
            maxHeight
        }
    }
    return filtered
}