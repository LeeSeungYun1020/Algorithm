fun main() {
    val num = readLine()!!.toInt()
    for (i in 1..num) {
        var sum = i
        var check = i
        while (check > 0) {
            sum += check % 10
            check /= 10
        }
        if (sum == num) {
            println(i)
            return
        }
    }
    println(0)
}