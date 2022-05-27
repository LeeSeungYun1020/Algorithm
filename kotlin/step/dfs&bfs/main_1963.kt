fun concat(one: Int, two: Int, three: Int, four: Int) = one * 1000 + two * 100 + three * 10 + four

fun main() {
    val prime = MutableList(10000) { it % 2 == 1 }
    for (i in 3..9999) {
        if (prime[i])
            for (j in 3..9999) {
                if (i * j < 10000) {
                    prime[i * j] = false
                }
            }
    }

    val n = readln().toInt()
    for (case in 1..n) {
        val (start, end) = readln().split(" ").map { it.toInt() }
        if (start == end) {
            println(0)
            continue
        }
        val deque = ArrayDeque<Pair<Int, Int>>()
        deque.add(start to 0)
        val visited = MutableList(10000) { false }
        visited[start] = true
        while (deque.isNotEmpty()) {
            val (num, turn) = deque.removeFirst()
            if (num == end) {
                println(turn)
                break
            }
            val one = num / 1000
            val two = num / 100 % 10
            val three = num / 10 % 10
            val four = num % 10

            for (i in 0..9) {
                for (target in listOf(concat(i, two, three, four), concat(one, i, three, four), concat(one, two, i, four), concat(one, two, three, i)))
                    if (target in 1000..9999 && !visited[target] && prime[target]) {
                        deque.add(target to turn + 1)
                        visited[target] = true
                    }
            }
        }
    }
}