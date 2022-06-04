fun main() {
    val n = readln().toInt()
    val card = readln().split(" ").associate { it.toInt() to true }
    val m = readln().toInt()
    val check = readln().split(" ").map { it.toInt() }


    check.forEach { if (card[it] == true) print("1 ") else print("0 ") }
}
