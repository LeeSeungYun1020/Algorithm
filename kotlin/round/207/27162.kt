import kotlin.math.max

fun main() {
    val play = readln().map { it == 'Y' }
    val fixedDice = readln().split(" ").map { it.toInt() }
    var answer = 0
    for (i in 0..5) {
        if (play[i])
            answer = max(answer, numbers(fixedDice, i + 1))
    }
    if (play[6])
        answer = max(answer, fourOfAKind(fixedDice))
    if (play[7])
        answer = max(answer, fullHouse(fixedDice))
    if (play[8])
        answer = max(answer, littleStraight(fixedDice))
    if (play[9])
        answer = max(answer, bigStraight(fixedDice))
    if (play[10])
        answer = max(answer, yacht(fixedDice))
    if (play[11])
        answer = max(answer, choice(fixedDice))
    println(answer)
}


fun numbers(list: List<Int>, number: Int): Int =
    (list.count { it == number } + 2) * number

fun fourOfAKind(list: List<Int>): Int {
    val (a, b, c) = list
    var ans = 0
    if (a == b || a == c) ans = max(ans, a * 4)
    if (b == c) ans = max(ans, b * 4)
    return ans
}

fun fullHouse(list: List<Int>): Int {
    val (a, b, c) = list
    if (a == b && b == c) return a * 3 + if (a != 6) 12 else 10

    if (a == b) return max(a * 3 + c * 2, a * 2 + c * 3)
    if (a == c) return max(a * 3 + b * 2, a * 2 + b * 3)
    if (b == c) return max(a * 3 + b * 2, a * 2 + b * 3)
    return 0
}

fun littleStraight(list: List<Int>): Int =
    if (setOf(1, 2, 3, 4, 5).intersect(list.toSet()).size == 3) 30 else 0

fun bigStraight(list: List<Int>): Int =
    if (setOf(2, 3, 4, 5, 6).intersect(list.toSet()).size == 3) 30 else 0

fun yacht(list: List<Int>): Int =
    if (list.toSet().size == 1) 50 else 0

fun choice(list: List<Int>): Int =
    list.sum() + 12