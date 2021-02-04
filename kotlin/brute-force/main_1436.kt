fun main() {
    val input = readLine()!!.toInt()
    if (input == 1) {
        println(666)
        return
    }

    var i = 1666
    var count = 1
    while (count < input) {
        if (i.toString().contains("666")) {
            count++
        }
        i++
    }
    println(i - 1)
}