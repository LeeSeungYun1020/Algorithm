fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val inDegree = MutableList(n) { 0 }
    val measure = List(n) { mutableListOf<Int>() }
    for (i in 0 until m) {
        val m = readln().split(" ").map { it.toInt() - 1 }
        inDegree[m[1]]++
        measure[m[0]].add(m[1])
    }

    val deque = ArrayDeque<Int>()
    deque.addAll(inDegree.withIndex().filter { it.value == 0 }.map { it.index })
    while (deque.isNotEmpty()) {
        val value = deque.removeFirst()
        print("${value+1} ")
        for (i in measure[value]) {
            inDegree[i] -= 1
            if (inDegree[i] == 0) {
                deque.add(i)
            }
        }
    }
}