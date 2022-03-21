import kotlin.math.absoluteValue

fun isRoad(list: List<Int>, length: Int): Boolean {
    val slope = MutableList(list.size) { false }
    var prev = list.first()
    var flat = 1
    for (i in 1..list.lastIndex) {
        if (list[i] == prev) {
            flat++
        } else {
            val height = list[i] - prev
            if (height.absoluteValue > 1) {
                return false
            } else if (height == 1) {
                if (flat >= length)
                    for (j in i-length until i)
                        slope[j] = true
                else
                    return false
            }
            flat = 1
        }
        prev = list[i]
    }
    prev = list.last()
    flat = 1
    for (i in list.lastIndex - 1 downTo 0) {
        if (list[i] == prev) {
            flat++
        } else if (list[i] - prev == 1) {
            if (flat >= length)
                for (j in i+1 .. i+length)
                    if (!slope[j])
                        slope[j] = true
                    else
                        return false
            else
                return false
            flat = 1
        }
        prev = list[i]
    }
    return true
}

fun main() {
    val (n, l) = readln().split(" ").map { it.toInt() }
    val map = List(n) { readln().split(" ").map { it.toInt() } }
    val road = (map + List(n) { i -> map.map { it[i] } })
    println(road.count { isRoad(it, l) })

}