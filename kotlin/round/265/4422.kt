fun main() {
    val target = "the quick brown fox jumps over the lazy dog"
    val blankPosition = 3
    val checker = target.toNumberList()
    val lines = buildList<String> {
        while (true) {
            readlnOrNull()?.let { add(it) } ?: break
        }
    }
    val finder = lines
        .filter { it.length == target.length && it[blankPosition] == ' ' }
        .find { compare ->
            compare.toNumberList() == checker
        }
    if (finder != null) {
        val converter = converter(target, finder)
        print(lines.joinToString("\n") { converter(it) })
    } else {
        print("No solution.")
    }
}

fun String.toNumberList(): List<Int> {
    val alpha = mutableMapOf<Char, Int>()
    var i = 0
    return map {
        alpha.getOrPut(it) { i++ }
    }
}

fun converter(origin: String, converted: String): (String) -> String {
    // converted -> origin
    val alpha = mutableMapOf<Char, Char>()
    origin.indices.forEach { i ->
        alpha[converted[i]] = origin[i]
    }
    return {
        it.map { c -> alpha[c] }
            .joinToString("")
    }
}