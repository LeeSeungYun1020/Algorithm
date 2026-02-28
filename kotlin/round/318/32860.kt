fun main() {
    var (year, count) = readln().split(" ").map { it.toInt() }
    count--
    val target = ('a'..'z').toList()
    val last = target[count % 26]
    val name = when (val first = count / 26) {
        0 -> last.uppercase()
        else -> "${target[first - 1]}${last}"
    }
    print("SN $year$name")
}