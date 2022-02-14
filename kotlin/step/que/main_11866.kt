fun main() {
    val num = readLine()!!.split(' ').map { it.toInt() }
    val que = ArrayDeque<Int>(num[0])
    val ans = ArrayDeque<Int>(num[0])
    (1..num[0]).toCollection(que)

    var i = 1
    while (que.size > 1){
        if (i % num[1] == 0)
            ans.add(que.removeFirst())
        else
            que.add(que.removeFirst())
        i++
    }
    print('<')
    ans.forEach { print("$it, ") }
    print(que.first())
    print('>')
}