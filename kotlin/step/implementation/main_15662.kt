enum class Mag {
    N, S
}

fun main() {
    val t = readln().toInt()
    val gear = List(t) { readln().map { if (it == '0') Mag.N else Mag.S } }
    val status = MutableList(t) { 0 }
    fun rotate(index: Int, direction: Int) {
        if (direction > 0) { // 시계 방향
            status[index] += 7
        } else { // 반시계 방향
            status[index] += 1
        }
        status[index] %= 8
    }

    fun List<Mag>.left(index: Int) = this[(status[index] + 6) % 8]
    fun List<Mag>.right(index: Int) = this[(status[index] + 2) % 8]

    val k = readln().toInt()
    val rotateMethod = List(k) { readln().split(" ").map { it.toInt() } }
    for (rm in rotateMethod) {
        val idx = rm[0] - 1
        var dir = rm[1]
        var left = idx
        var right = idx
        for (i in idx - 1 downTo 0) {
            val prev = gear[i + 1].left(i + 1)
            val now = gear[i].right(i)
            if (prev == now) break
            left = i
            dir = dir.inv() + 1
        }
        for (i in idx + 1 until t) {
            val prev = gear[i - 1].right(i - 1)
            val now = gear[i].left(i)
            if (prev == now) break
            right = i
        }

        for (i in left..right) {
            rotate(i, dir)
            dir = dir.inv() + 1
        }
    }
    println(gear.filterIndexed { index, mags -> mags[status[index]] == Mag.S }.count())
}