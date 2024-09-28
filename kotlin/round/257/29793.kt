fun main() {
    val (numberOfTargets, hp) = readln().split(" ").map { it.toInt() }
    val targets = readln()

    println(
        when (numberOfTargets) {
            1 -> 0
            2 -> {
                when (hp) {
                    1 -> 0
                    else -> hpDiffImpl(targets)
                }
            }
            3 -> {
                when (hp) {
                    1 -> 0
                    2 -> hpDiffImpl(targets)
                    else -> hpRotateImpl(targets)
                }
            }
            else -> {
                when (hp) {
                    1 -> 0
                    2 -> hpDiffImpl(targets)
                    3 -> hpRotateImpl(targets)
                    else -> -1
                }
            }
        }
    )
}

/**
 * 앞뒤 다른 상태 반복 중 가장 적은 변경 계산
 */
fun hpDiffImpl(targets: String): Int {
    var change = 0
    var prev = 'a'
    var count = 0
    for (target in targets) {
        if (prev == target) {
            count++
        } else {
            change += (count / 2)
            prev = target
            count = 1
        }
    }
    return change + (count / 2)
}

/**
 * SRW, SWR, RSW, RWS, WSR, WRS 반복 중 가장 적은 변경 계산
 */
fun hpRotateImpl(targets: String): Int {
    return listOf("SRW", "SWR", "RSW", "RWS", "WSR", "WRS").minOf { word ->
        targets.chunked(3).sumOf {
            it.mapIndexed { index, c -> word[index] != c }.count { it }
        }
    }
}