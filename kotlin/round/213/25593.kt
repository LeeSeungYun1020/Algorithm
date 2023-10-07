fun main() {
    val time = mutableMapOf<String, Int>()
    val numberOfWeek = readln().toInt()
    repeat(numberOfWeek) {
        readln().split(" ").map { time[it] = time.getOrDefault(it, 0) + 4 }
        readln().split(" ").map { time[it] = time.getOrDefault(it, 0) + 6 }
        readln().split(" ").map { time[it] = time.getOrDefault(it, 0) + 4 }
        readln().split(" ").map { time[it] = time.getOrDefault(it, 0) + 10 }
    }
    time.remove("-")
    if (time.keys.size == 0) println("Yes")
    else println(if (time.maxOf { it.value } - time.minOf { it.value } <= 12) "Yes" else "No")
}