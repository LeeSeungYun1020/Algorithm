fun main() {
    val count = readLine()!!.toInt()
    val list = mutableListOf<Int>()
    for (i in 1..count){
        val command = readLine()!!.split(' ')
        when(command.first()){
            "push" -> list.add(command.last().toInt())
            "pop" -> println(list.removeLastOrNull() ?: -1)
            "size" -> println(list.size)
            "empty" -> println(if (list.isEmpty()) 1 else 0)
            "top" -> println(list.lastOrNull() ?: -1)
        }
    }
}