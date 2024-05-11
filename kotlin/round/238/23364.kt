fun main() {
    val map = mutableMapOf<String, Int>()

    readln()
    readln().split(" ").forEachIndexed { index, key ->
        if (map[key] != null) {
            println("${map[key]} ${index + 1}")
        } else {
            map[key] = index + 1
        }
    }
}