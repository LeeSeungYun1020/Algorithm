fun main() {
    val count = readLine()!!.toInt()
    val num = mutableListOf<Int>()
    for (i in 0 until count){
        num.add(readLine()!!.toInt())
    }
    num.sorted().forEach { println(it) }
}