fun main() {
    val count = readLine()!!.toInt()
    val info = mutableListOf<Pair<Int, String>>()
    for (i in 1..count){
        val tem = readLine()!!.split(" ")
        info.add(tem.first().toInt() to tem.last())
    }
    info.sortedBy { it.first }.forEach { println("${it.first} ${it.second}") }
}