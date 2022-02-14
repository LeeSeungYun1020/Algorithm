import kotlin.math.pow

fun main() {
    while (true){
        val num = readLine()!!.split(" ").map { it.toInt() }
        if (num.all { it == 0 })
            break
        val list = num.map { it.toDouble().pow(2) }.sorted()
        if (list[0] + list[1] == list[2]){
            println("right")
        } else {
            println("wrong")
        }
    }
}