import kotlin.math.sqrt

fun main() {
    var num = readLine()!!.toInt()
    val standard = sqrt(num.toDouble())
    var i = 2
    while (i <= standard){
        if (num % i == 0){
            println(i)
            num /= i
        } else i++
    }
    if (num != 1)
        println(num)
}