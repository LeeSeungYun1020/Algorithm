enum class Type {
    WHITE, RED, BLUE
}

data class Horse(var d: Int)

lateinit var status: MutableMap<Pair<Int, Int>, List<Int>>
lateinit var horse: List<Horse>

fun calcTargetXY(h: Int, x: Int, y: Int) = when (horse[h].d) {
    0 -> x to y + 1
    1 -> x to y - 1
    2 -> x - 1 to y
    else -> x + 1 to y
}

fun move(from: Pair<Int, Int>, to: Pair<Int, Int>, reverse: Boolean = false): Boolean {
    val x = from.first
    val y = from.second
    val targetX = to.first
    val targetY = to.second
    // 말 올리기
    val origin = status[targetX to targetY]
    val replace =
        (if (reverse)
            status.remove(x to y)?.reversed()
        else
            status.remove(x to y))
            ?: listOf()
    status[targetX to targetY] =
        if (origin.isNullOrEmpty())
            replace
        else
            origin + replace
    return (status[targetX to targetY]?.size ?: 0) >= 4
}

fun main() {
    // 체스판 크기, 말의 개수
    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    // 체스판 정보(N줄) - 0: 흰색, 1: 빨간색, 2: 파란색
    val board = List(N) {
        readLine()!!.split(" ").map {
            when (it.trim()) {
                "0" -> Type.WHITE
                "1" -> Type.RED
                else -> Type.BLUE
            }
        }
    }
    status = mutableMapOf()

    // 말 정보(K줄) - 행, 열, 방향(1: 오, 2: 왼, 3: 위, 4: 아래) - 1
    horse = List(K) {
        val (x, y, d) = readLine()!!.split(" ").map { it.toInt() - 1 }
        status[x to y] = listOf(it)
        Horse(d)
    }

    for (i in 1..1000) {
        for ( h in 0 until K) {
            val pos = status.filter { it.value.first() == h }.map { it.key }.firstOrNull() ?: continue

            val x = pos.first
            val y = pos.second

            val (targetX, targetY) = calcTargetXY(h, x, y)
            val target = board.getOrNull(targetX)?.getOrNull(targetY)?: Type.BLUE
            if (target == Type.BLUE) {
                // 이동 방향 반대로 하고
                horse[h].d = when (horse[h].d) {
                    0 -> 1
                    1 -> 0
                    2 -> 3
                    else -> 2
                }
                // 이동하려는 칸 파악
                val (nTargetX, nTargetY) = calcTargetXY(h, x, y)
                // 파랑이 아닌 경우 한 칸 이동
                val nTarget = board.getOrNull(nTargetX)?.getOrNull(nTargetY) ?: Type.BLUE
                if (nTarget != Type.BLUE && move(x to y, nTargetX to nTargetY, nTarget == Type.RED)) {
                    println(i)
                    return
                }
            }
            else {
                // 화이트나 레드인 경우 - 레드일 때만 리버스 필요
                if (move(x to y, targetX to targetY, target == Type.RED)) {
                    println(i)
                    return
                }
            }
        }
    }
    println(-1)
}