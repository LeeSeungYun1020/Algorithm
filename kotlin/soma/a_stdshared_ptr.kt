data class Pointer(var objectNumber: Int)

fun main() {
    val (N, M, Q) = readln().split(" ").map { it.toInt() }
    val pointers = List(M) { Pointer(readln().toInt()) }
    for (i in 1..Q) {
        val command = readln().split(" ")
        when (command[0]) {
            "assign" -> {
                val x = command[1].toInt() - 1
                val y = command[2].toInt() - 1
                pointers[x].objectNumber = pointers[y].objectNumber
            }
            "swap" -> {
                val x = command[1].toInt() - 1
                val y = command[2].toInt() - 1
                val temp = pointers[x].objectNumber
                pointers[x].objectNumber = pointers[y].objectNumber
                pointers[y].objectNumber = temp
            }
            "reset" -> {
                val x = command[1].toInt() - 1
                pointers[x].objectNumber = 0
            }
        }
    }
    val ans = pointers.filter { it.objectNumber != 0 }.toSet().sortedBy { it.objectNumber }
    println(ans.size)
    ans.forEach { println(it.objectNumber) }
}