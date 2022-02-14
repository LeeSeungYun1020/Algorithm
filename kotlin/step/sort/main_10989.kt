fun main() {
    val num = IntArray(10001)
    val count = readLine()!!.toInt()
    for (i in 0 until count){
        num[readLine()!!.toInt()]++
    }
    num.forEachIndexed { index, n -> if (n > 0) print("$index\n".repeat(n)) }
}