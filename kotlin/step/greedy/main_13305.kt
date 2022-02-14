fun main() {
    val count = readLine()!!.toInt()
    val road = readLine()!!.split(' ').map { it.toInt() }
    val oil = readLine()!!.split(' ').map { it.toInt() }

    var minPrice = oil[0]
    var distance = road[0].toLong()
    var ans = 0L
    for (i in 1 until count - 1) {
        if (minPrice > oil[i]) {
            ans += (minPrice * distance)
            minPrice = oil[i]
            distance = road[i].toLong()
        } else
            distance += road[i]
    }
    ans += (minPrice * distance)
    print(ans)
}