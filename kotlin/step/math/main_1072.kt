fun main() {
    val (x, y) = readln().split(" ").map { it.toLong() }
    val z = y * 100 / x

    if (z >= 99) {
        println(-1)
        return
    }

    val up = x * (z + 1) - 100 * y
    val down = 99 - z

    if (up % down != 0L)
        println(up / down + 1)
    else
        println(up / down)
}