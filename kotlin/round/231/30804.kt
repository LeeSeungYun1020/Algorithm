import kotlin.math.max

fun main() {
    readln()
    val fruits = readln().split(" ").map { it.toInt() }

    if (fruits.size <= 2) {
        println(fruits.size)
        return
    }

    var answer = 0
    var start = 0
    var firstStart = 0
    var secondStart = 1
    var first = fruits[firstStart]
    var second = fruits[secondStart]
    for (index in 2..fruits.lastIndex) {
        val prev = fruits[index - 1]
        val now = fruits[index]
        if (first == second) {
            if (prev != now) {
                second = now
                secondStart = index
            }
            continue
        }

        when (prev) {
            first -> {
                when (now) {
                    first -> {}
                    second -> {
                        secondStart = index
                    }

                    else -> {
                        // first-now 구성으로 변경
                        // 꼬치 길이 계산
                        answer = max(answer, index - start)
                        start = firstStart
                        // first는 그대로 유지
                        // second를 now로 교체
                        secondStart = index
                        second = now
                    }
                }
            }

            second -> {
                when (now) {
                    first -> {
                        firstStart = index
                    }

                    second -> {}
                    else -> {
                        // second-now 구성으로 변경
                        // 꼬치 길이 계산
                        answer = max(answer, index - start)
                        // first를 second로 변경
                        firstStart = secondStart
                        first = second
                        start = firstStart
                        // second를 now로 변경
                        secondStart = index
                        second = now
                    }
                }
            }
        }
    }
    answer = max(answer, fruits.size - start)
    println(answer)
}