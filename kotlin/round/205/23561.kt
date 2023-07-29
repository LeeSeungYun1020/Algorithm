fun main() {
    val i = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }.sorted()
    println(list[list.lastIndex - i] - list[i])
}