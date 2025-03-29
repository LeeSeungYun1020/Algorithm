fun main() {
    List(readln().toInt()) {
        readln().split(" ").map { it.toInt() }.let { Mountain(it[0], it[1]) }
    }
        .sortedByDescending { it.height }
        .fold(mutableListOf<Mountain>()) { list, mountain ->
            list.apply {
                if (!list.any { it.heightAt(mountain.location) >= mountain.height }) add(mountain)
            }
        }.size.let { println(it) }
}

class Mountain(val location: Int, val height: Int) {
    fun heightAt(target: Int): Int {
        return when {
            target <= location - height -> 0
            target < location -> target - location + height
            target < location + height -> location + height - target
            else -> 0
        }
    }
}