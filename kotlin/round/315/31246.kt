fun main() {
    val (numberOfInputs, target) = readln().split(" ").map { it.toInt() }
    val info = List(numberOfInputs) { readln().split(" ").map { it.toInt() }.let { it[1] - it[0] } }.sorted()

    if (target == 0) {
        println(0)
        return
    }
    var increase = 0
    var count = 0
    info.forEach {
        if (it <= increase) count++
        else {
            increase = it
            count++
        }
        if (count >= target) {
            println(increase)
            return
        }
    }
}