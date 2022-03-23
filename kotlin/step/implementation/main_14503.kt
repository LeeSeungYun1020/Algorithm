enum class Direction {
    N, E, S, W
}

fun Direction.left() = when(this) {
    Direction.N -> Direction.W
    Direction.E -> Direction.N
    Direction.S -> Direction.E
    Direction.W -> Direction.S
}

fun Direction.leftPosition() = when(this) {
    Direction.N -> 0 to -1
    Direction.E -> -1 to 0
    Direction.S -> 0 to 1
    Direction.W -> 1 to 0
}

fun Direction.backPosition() = when(this) {
    Direction.N -> 1 to 0
    Direction.E -> 0 to -1
    Direction.S -> -1 to 0
    Direction.W -> 0 to 1
}

operator fun Pair<Int,Int>.plus(a: Pair<Int, Int>): Pair<Int, Int> {
    return (this.first + a.first) to (this.second + a.second)
}

operator fun List<List<Boolean>>.get(a: Pair<Int, Int>): Boolean{
    return this[a.first][a.second]
}

operator fun List<MutableList<Boolean>>.set(a: Pair<Int, Int>, b: Boolean){
    this[a.first][a.second] = b
}

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val (r, c, d) = readln().split(" ").map { it.toInt() }
    val room = List(n) { readln().split(" ").map { it == "0" } }
    val dirty = room.map { it.toMutableList() }

    var direction = Direction.values()[d]
    var ans = 1
    var pos = r to c
    var check = 0
    dirty[pos] = false
    while (true) {
        val next = pos + direction.leftPosition()
        direction = direction.left()
        if (dirty[next]) {
            ans += 1
            pos = next
            check = 0
            dirty[pos] = false
        } else {
            check++
            if (check == 4) {
                check = 0
                val back = pos + direction.backPosition()
                if (room[back]) pos = back
                else break
            }
        }
    }
    println(ans)
}