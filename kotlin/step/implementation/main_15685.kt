enum class Direction{
    RIGHT, UP, LEFT, DOWN
}
class Curve(val x: Int, val y: Int, val direction: Direction, val generation: Int)

fun Direction.rotate() = when(this) {
    Direction.RIGHT -> Direction.UP
    Direction.UP -> Direction.LEFT
    Direction.LEFT -> Direction.DOWN
    Direction.DOWN -> Direction.RIGHT
}

fun move(x: Int, y: Int, direction: Direction): Pair<Int, Int> {
    return when(direction) {
        Direction.RIGHT -> x + 1 to y
        Direction.UP -> x to y - 1
        Direction.LEFT -> x - 1 to y
        Direction.DOWN -> x to y + 1
    }
}

fun main() {
    val n = readln().toInt()
    val curve = List(n) {
        val (x, y, d, g) = readln().split(" ").map { it.toInt() }
        Curve(x, y, Direction.values()[d], g)
    }
    val points = List(101) { MutableList(101) { false } }
    for (c in curve) {
        var x = c.x
        var y = c.y
        val dragon = mutableListOf<Direction>()
        dragon.add(c.direction)
        points[y][x] = true
        val m = move(x, y, c.direction)
        x = m.first
        y = m.second
        points[y][x] = true

        for (g in 1..c.generation) {
            for (i in dragon.lastIndex downTo 0) {
                val d = dragon[i].rotate()
                dragon.add(d)
                val m = move(x, y, d)
                x = m.first
                y = m.second
                points[y][x] = true
            }
        }
    }
    var ans = 0
    for (i in 0..100) {
        for (j in 0..100) {
            if (points[i][j] && points.getOrNull(i+1)?.getOrNull(j) == true
                && points[i].getOrNull(j+1) == true && points.getOrNull(i+1)?.getOrNull(j+1) == true)
                ans++
        }
    }
    println(ans)
}