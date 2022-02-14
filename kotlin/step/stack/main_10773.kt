fun main() {
    val count = readLine()!!.toInt()
    val list = mutableListOf<Int>()
    for (i in 1..count){
        readLine()!!.toInt().also {
            when (it) {
                0 -> list.removeLast()
                else -> list.add(it)
            }
        }
    }
    println(list.sum())
}