fun main() {
    readln()
    val account = readln().split(" ").map { it.toInt() }
    val my = account.first()
    if (my == 0) {
        println(0)
        return
    }

    val filtered = account.filter { it > 0 }
    val interest = readln().toInt()
    val week = readln().toInt()
    println(my + week.toDouble() * interest * my / filtered.sum())
}