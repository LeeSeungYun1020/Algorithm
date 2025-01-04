fun main() {
    val (_, delay) = readln().split(" ").map { it.toInt() }
    val sounds = readln().split(" ").map { it.toInt() }

    var check = 0
    var count = 0
    sounds.forEach { sound ->
        if (check < sound) {
            check = sound + delay
            count++
        }
    }
    println(count)
}