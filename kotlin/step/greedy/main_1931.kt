fun main() {
    val count = readLine()!!.toInt()
    var end = 0
    var ans = 0
    List(count) {
        val (a, b) = readLine()!!.split(' ').map { it.toInt() }
        a to b
    }.sortedWith {a, b ->
        val cmp = a.second - b.second
        if (cmp == 0)
            a.first - b.first
        else cmp
    }.forEach {
        if (end <= it.first) {
            end = it.second
            ans++
        }
    }
    print(ans)
}