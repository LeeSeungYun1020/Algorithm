fun main() {
    buildList<Int>() {
        repeat(readln().toInt()) {
            readln()
            buildMap<Char, State> {
                readln().withIndex().reversed().forEach { (index, key) ->
                    putIfAbsent(key, State(0, index))
                    getValue(key).num++
                }
            }.entries.drop(1).reversed().fold(-1 to 0 /* level, answer */) { (level, answer), entry ->
                val nl = level + entry.value.num
                nl to answer + (entry.value.index - nl) * entry.value.num
            }.run { add(second * 5) }
        }
    }.joinToString("\n").let(::print)
}

data class State(var num: Int, val index: Int)