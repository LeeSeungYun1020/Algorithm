fun main() {
    readln()
    val v = readln().split(" ").map { it.toLong() }.toSet()
    var count = 0
    fun retrieve(target: Long): Boolean {
        if (target in v) return true
        count++
        if (target >= 1L shl 60) return false
        if (!retrieve(target * 2)) return false
        if (!retrieve(target * 2 + 1)) return false
        return true
    }
    if (retrieve(1L)) println(count) else println(-1)
}