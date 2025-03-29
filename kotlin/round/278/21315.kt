import kotlin.math.min

fun main() {
    readln()
    val cards = readln().split(" ").map { it.toInt() }
    val kList = generateSequence(1) { it * 2 }
        .takeWhile { it < cards.size }
        .toList()
    val order = kList
        .reversed()
        .map { (it + 1)..min(it * 2, cards.size) }
        .fold(emptyList<Int>()) { list, current -> list + current } + 1

    fun shuffle(target: List<Int>, k: Int): List<Int> {
        return target.takeLast(target.size - kList[k]) +
                order.takeLast(kList[k])
                    .map { target[it - 1] }
    }

    for (case1 in kList.indices) {
        for (case2 in kList.indices) {
            if (shuffle(shuffle(cards, case2), case1).withIndex().all { (index, value) -> index + 1 == value }) {
                println("$case1 $case2")
                return
            }
        }
    }
}