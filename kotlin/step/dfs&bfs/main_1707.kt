fun main() {
    val count = readLine()!!.toInt()
    for (c in 1..count) {
        val (v, e) = readLine()!!.split(' ').map { it.toInt() }
        val visited = Array(v + 1) { Visited.NOT }
        val connection = Array(v + 1) { mutableListOf<Int>() }
        for (i in 1..e) {
            val (a, b) = readLine()!!.split(' ').map { it.toInt() }
            connection[a].add(b)
            connection[b].add(a)
        }
        val deq = ArrayDeque<Int>()
        var pass = true
        for (i in 1..v) {
            if (connection[i].isNotEmpty() && visited[i] == Visited.NOT) {
                visited[i] = Visited.RIGHT
                deq.add(i)
                while (deq.isNotEmpty()) {
                    val pos = deq.removeFirst()
                    for (cmp in connection[pos]) {
                        if (visited[cmp] == Visited.NOT) {
                            visited[cmp] = !visited[pos]
                            deq.add(cmp)
                        } else if (visited[cmp] == visited[pos]) {
                            pass = false
                            break
                        }
                    }
                    if (!pass) break
                }
            }
            if (!pass) break
        }
        println(if (pass) "YES" else "NO")
    }
}

enum class Visited {
    NOT{
        override operator fun not(): Visited {
            return NOT
        }
       },
    LEFT{
        override operator fun not(): Visited {
            return RIGHT
        }
        },
    RIGHT{
        override operator fun not(): Visited {
            return LEFT
        }
    };

    abstract operator fun not(): Visited
}