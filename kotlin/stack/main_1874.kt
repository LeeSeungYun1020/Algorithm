fun main() {
    val count = readLine()!!.toInt()
    val list = mutableListOf<Int>()
    val ans = mutableListOf<Char>()
    var push = 1
    for (i in 1..count) {
        val num = readLine()!!.toInt()
        while (num >= push) {
            list.add(push++)
            ans.add('+')
        }
        if (num == list.last()) {
            list.removeLast()
            ans.add('-')
        } else
            break
    }
    if (list.size != 0)
        println("NO")
    else
        ans.forEach { println(it) }
}