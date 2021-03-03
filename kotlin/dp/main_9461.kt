fun main() {
    val array = LongArray(101)
    array[1] = 1
    array[2] = 1
    for (i in 3..100) {
        array[i] = (array[i - 3] + array[i - 2])
    }
    for (c in 1..readLine()!!.toInt()) {
        println(array[readLine()!!.toInt()])
    }
}