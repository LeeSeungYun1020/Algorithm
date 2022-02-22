fun main() {
    // 사람 수, 파티 수
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    // 진실 아는 사람 수, ... 사람들의 번호
    val truePeople = readLine()!!.split(" ").map { it.toInt() }.drop(1).toMutableSet()
    // 파티마다 오는 사람 수, ... 사람들의 번호
    val party = List(M) { readLine()!!.split(" ").map { it.toInt() }.drop(1) }

    var pass = false
    while (!pass) {
        pass = true
        for (pl in party) {
            for (p in pl) {
                if (p in truePeople) {
                    if (truePeople.addAll(pl))
                        pass = false
                    break
                }
            }
        }
    }

    var count = 0
    for (pl in party) {
        if (!pl.any { it in truePeople })
            count++
    }
    println(count)
}