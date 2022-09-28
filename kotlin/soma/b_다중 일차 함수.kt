fun main() {
    val N = readln().toInt()
    var (px, py) = readln().split(" ").map { it.toInt() }
    val answer = mutableListOf<Pair<Int, Int>>(px to 0)
    for (i in 2..N) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        val increase = when {
            y < py -> -1
            y == py -> 0
            else -> 1
        }
        answer.add(x to increase)
        px = x
        py = y
    }

    val Q = readln().toInt()
    for (i in 1..Q) {
        val k = readln().toDouble()
        for (ans in answer) {
            if (ans.first >= k) {
                println(ans.second)
                break
            }
        }
    }
}