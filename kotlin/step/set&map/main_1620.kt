fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val pocket = List(n) { i -> i + 1 to readln() }
    val numMap = pocket.toMap()
    val enMap = pocket.associate { it.second to it.first }

    for (i in 1..m) {
        val input = readln()
        if (enMap[input] != null){
            println(enMap[input])
        } else {
            println(numMap[input.toInt()])
        }
    }
}
