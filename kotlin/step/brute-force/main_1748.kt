fun main() {
    val input = readLine()!!
    val num = input.toInt()

    var ten = 1
    var count = 0
    for (i in 1 until input.length) {
        val mTen = ten * 10
        count += (mTen - ten) * i
        ten = mTen
    }
    count += (num - ten + 1) * input.length
    println(count)
}