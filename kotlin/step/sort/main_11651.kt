fun main() {
    val count = readLine()!!.toInt()
    val point = mutableListOf<Point>()
    for (i in 1..count){
        val tem = readLine()!!.split(" ").map { it.toInt() }
        point += Point(tem.first(), tem.last())
    }
    point.sorted().forEach { println(it) }
}

data class Point(val x: Int, val y: Int): Comparable<Point>{
    override fun compareTo(other: Point) = when (y) {
        other.y -> x.compareTo(other.x)
        else -> y.compareTo(other.y)
    }

    override fun toString() = "$x $y"
}