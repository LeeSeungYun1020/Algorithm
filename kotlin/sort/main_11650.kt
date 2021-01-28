fun main() {
    val count = readLine()!!.toInt()
    val point = mutableListOf<Point>()
    for (i in 1..count){
        val tem = readLine()!!.split(" ").map { it.toInt() }
        point += Point(tem.first(), tem.last())
    }
    point.sorted().forEach { println(it) }
}

class Point(private val x: Int, private val y: Int): Comparable<Point>{
    override fun compareTo(other: Point) = when (x) {
        other.x -> y.compareTo(other.y)
        else -> x.compareTo(other.x)
    }

    override fun toString() = "$x $y"
}