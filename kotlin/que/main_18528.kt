fun main() {
    val count = readLine()!!.toInt()
    val que = mutableListOf<Int>()
    for (i in 1..count){
        val command = readLine()!!.split(' ')
        when(command[0]){
            "push" -> que.add(command[1].toInt())
            "pop" -> println(que.removeFirstOrNull() ?: -1)
            "size" -> println(que.size)
            "empty" -> println( if (que.isEmpty()) 1 else 0 )
            "front" -> println(que.firstOrNull() ?: -1)
            "back" -> println(que.lastOrNull() ?: -1)
        }
    }
}