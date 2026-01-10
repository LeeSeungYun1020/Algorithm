import kotlin.math.absoluteValue

fun main() {
    val stations = readln().split(" ").map { it.toInt() }.chunked(2)

    fun distance(x1: Int, y1: Int, x2: Int, y2: Int) = (x1 - x2).absoluteValue + (y1 - y2).absoluteValue

    repeat(readln().toInt()) {
        val query = readln().split(" ").map { it.toInt() }
        val (x, y) = query.slice(0..1)
        stations.zip(query.slice(2..4)).minOf { (pos, interval) ->
            distance(x, y, pos[0], pos[1]).let { d ->
                val extra = if (d % interval == 0) 0 else 1
                interval * (d / interval + extra)
            }
        }.run(::println)
    }
}