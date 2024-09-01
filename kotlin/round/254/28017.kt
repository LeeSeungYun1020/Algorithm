fun main() {
    val (numberOfRounds, numberOfWeapons) = readln().split(" ").map { it.toInt() }
    val clearTimes = List(numberOfRounds) {
        readln().split(" ").map { it.toInt() }
    }

    val dp = List(numberOfRounds) { MutableList(numberOfWeapons) { Int.MAX_VALUE } }
    for (i in 0 until numberOfWeapons) {
        dp[0][i] = clearTimes[0][i]
    }
    for (round in 1 until numberOfRounds) {
        for (weapon in 0 until numberOfWeapons) {
            dp[round][weapon] = dp[round - 1].withIndex().minOf {
                // 앞 턴에서 사용한 무기 다음 턴에 사용 불가
                if (it.index == weapon) Int.MAX_VALUE else it.value
            } + clearTimes[round][weapon]
        }
    }
    println(dp.last().minOf { it })
}