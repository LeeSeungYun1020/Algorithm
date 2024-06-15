fun main() {
    val plain = readln()
    val cipher = readln()
    val keyLoop = cipher - plain

    for (target in 1..plain.length) {
        if (plain.length % target == 0) {
            val key = keyLoop.chunked(target)
            if (key.all { it == key.first() }) {
                println(key.first())
                return
            }
        }
    }
}

operator fun String.minus(other: String): String {
    return buildString {
        for (i in this@minus.indices) {
            var calc = this@minus[i] - other[i]
            if (calc <= 0) calc += 26
            append('A' - 1 + calc)
        }
    }
}
