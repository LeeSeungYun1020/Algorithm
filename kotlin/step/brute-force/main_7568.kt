fun main() {
    val count = readLine()!!.toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    for (i in 1..count) {
        val (x, y) = readLine()!!.split(' ').map { it.toInt() }
        list.add(x to y)
    }
    list.forEach { origin ->
        print("${list.count{ cmp ->
            origin.first < cmp.first && origin.second < cmp.second
        } + 1} ")
    }
}