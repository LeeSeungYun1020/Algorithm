fun main() {
    val numbers = List(readln().toInt()) { readln().toInt() }
    numbers.withIndex().sortedBy { it.value }.withIndex().maxOf { (oldIndex, iValue) ->
        val (newIndex, value) = iValue
        if (newIndex > oldIndex) newIndex - oldIndex else 0
    }.run { println(this + 1) }
}