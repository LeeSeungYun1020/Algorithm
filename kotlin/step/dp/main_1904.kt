fun main() {
    val num = readLine()!!.toInt()
    val array = IntArray(num + 1) { 1 }
    for (i in 2..num) {
        array[i] = (array[i - 2] + array[i - 1]) % 15746
    }
    print(array[num])
}