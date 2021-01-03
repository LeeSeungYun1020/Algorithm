import kotlin.math.min

fun main() {
    val num = readLine()!!.toInt()
    val list = mutableListOf(0, 0)

    for (i in 2..num){
        list.add(i, when {
            i % 6 == 0 -> {
                minOf(list[i/3], list[i/2], list[i-1]) + 1
            }
            i % 3 == 0 -> {
                min(list[i/3], list[i-1]) + 1
            }
            i % 2 == 0 -> {
                min(list[i/2], list[i-1]) + 1
            }
            else -> list[i-1] + 1
        })
    }
    println(list[num])
}