fun main() {
    val count = readLine()!!.toInt()
    for (i in 1..count){
        val (n, m) = readLine()!!.split(' ').map { it.toInt() }
        val importance = ArrayDeque<Pair<Int, Int>>(n)
        readLine()!!.split(' ').mapIndexed { index: Int, s: String -> index to s.toInt() }.toCollection(importance)
        var print = 0
        while (importance.size > 1){
            if (importance.maxOf { it.second } == importance.first().second) {
                if (importance.removeFirst().first == m)
                    break
                print++
            } else {
                importance.add(importance.removeFirst())
            }
        }
        println(print + 1)
    }
}