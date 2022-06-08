fun main() {
    readln()
    val a = readln().split(" ").map { it.toInt() }
    val b = readln().split(" ").map { it.toInt() }
    val aMap = a.associateWith { true }
    println(a.count() + b.count() - b.count{ aMap[it] == true } * 2)
}