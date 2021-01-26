fun main() {
    val lines = readLine()!!.split("\n")
    for (line in lines.subList(1, lines.lastIndex + 1)){
        val (h, _, n) = line.split(" ").map { it.toInt() }
        var floor = n % h
        var room = n / h + 1
        if (floor == 0) {
            floor = h
            room -= 1
        }
        println("$floor${if (room < 10) "0" else ""}${room}")
    }
}