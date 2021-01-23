import kotlin.math.max

fun main() {
    val num = readLine()!!.toInt()
    val list = readLine()!!.split(" ").map{ it.toInt() }
    val up = MutableList(num) { 1 }
    val down = MutableList(num) { 1 }
    val dp = mutableListOf(1)

    for (i in 1 until num){
        for (j in 0 until i) {
            if (list[i] > list[j])
                up[i] = max(up[i], up[j] + 1)
        }
    }
    for (i in (num - 1).downTo(0)){
        for (k in (num - 1).downTo(i)){
            if (list[i] > list[k])
                down[i] = max(down[i], down[k] + 1)
        }
        dp.add(up[i] + down[i] - 1)
    }
    println(dp.maxOrNull())
}