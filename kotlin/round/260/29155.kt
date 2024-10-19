fun main() {
    val n = readln().toInt()
    val numberOfProblems = readln().split(" ").map { it.toInt() }.toMutableList()
    println((List(n) {
        val (rank, time) = readln().split(" ").map { it.toInt() }
        Problem(rank, time)
    } + Problem(0, 0)).sortedWith(compareBy({ it.rank }, { it.time })).filter {
        it.rank == 0 || numberOfProblems[it.rank - 1]-- > 0
    }.windowed(2) { (prev, current) ->
        Problem(current.rank, time = when (prev.rank) {
            0 -> current.time
            current.rank -> current.time + (current.time - prev.time)
            else -> current.time + 60
        })
    }.sumOf { it.time })
}

data class Problem(val rank: Int, val time: Int)