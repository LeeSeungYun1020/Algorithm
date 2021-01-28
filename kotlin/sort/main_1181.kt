fun main() {
    val count = readLine()!!.toInt()
    val words = mutableListOf<String>()
    for (i in 1..count){
        words.add(readLine()!!)
    }
    words.toSortedSet().sortedBy { it.length }.forEach { println(it) }
}