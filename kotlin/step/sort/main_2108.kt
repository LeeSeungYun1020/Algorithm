import kotlin.math.round

fun main() {
    val count = readLine()!!.toInt()
    val list = mutableListOf<Int>()
    for (i in 1..count){
        list.add(readLine()!!.toInt())
    }
    list.sort()
    println(round(list.average()).toInt())
    println(list[count / 2])
    list.groupingBy { it }.eachCount().toList().sortedByDescending { it.second }.apply {
        println(when {
            size == 1 -> get(0).first
            get(0).second == get(1).second -> get(1).first
            else -> get(0).first
        })
    }
    println(list[count - 1] - list[0])
}