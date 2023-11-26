fun main() {
    val (n, _) = readln().split(" ").map { it.toInt() }

    println(buildList<List<Int>> {
        repeat(n) {
            addAll(readln().split("0").map { it.trim() }.filter { it.isNotBlank() }
                .map { it.split(" ").map { it.toInt() } })
        }
    }.sumOf { line ->
        val start = line.first()
        1 + line.windowed(2).count { it[0] != it[1] && it[1] != start }
    })
}