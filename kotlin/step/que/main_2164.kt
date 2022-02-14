fun main() {
    val num = readLine()!!.toInt()
    val list = ArrayDeque<Int>(num)
    (1..num).toCollection(list)
    while (list.size > 1){
        list.removeFirst()
        list.add(list.removeFirst())
    }
    println(list.first())
}