fun main() {
    val num = readLine()!!.toInt()
    var prev: Long = 1
    var now: Long = 1
    for (i in 2 until num) {
        var tem = now
        now += prev
        prev = tem
    }
    println(now)
}