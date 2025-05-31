fun main() {
    val n = readln().toInt()
    val plants = List(n) { readln().split(" ").map{ it.toInt() } }
    val state = mutableSetOf<Int>()
    plants.count{
        val b = it.intersect(state).size == 0
        state.addAll(it)
        b
    }.run { println(this) }
}