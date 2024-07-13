fun main() {
    val (_, maxOfNa, limitOfTransport) = readln().split(" ").map { it.toInt() }
    val baskets = readln().split(" ").map { it.toInt() }.sorted()

    val checksum = baskets.fold(0L) { acc, v -> acc + v }
    if (checksum == 0L) {
        println("YES")
        return
    } else if (checksum % maxOfNa != 0L) {
        println("NO")
        return
    }

    var countOfTransport = 0
    var start = 0
    var end = baskets.lastIndex
    var startTarget = baskets[start]
    var endTarget = baskets[end]

    fun nextStart() {
        start++
        startTarget = baskets[start]
    }

    fun nextEnd() {
        end--
        endTarget = baskets[end]
    }

    fun move(need: Int) {
        if (need == 0) return
        if (startTarget > need) {
            startTarget -= need
            countOfTransport += need
            nextEnd()
        } else if (startTarget == need) {
            countOfTransport += need
            nextStart()
            nextEnd()
        } else {
            countOfTransport += startTarget
            val remain = need - startTarget
            nextStart()
            move(remain)
        }
    }

    while (start <= end) {
        move(maxOfNa - endTarget)
        if (countOfTransport > limitOfTransport) {
            println("NO")
            return
        }
    }
    println("YES")
}