fun main() {
    val t = readln().toInt()
    repeat(t) {
        if (CardCollector(readln().split(" ").map { it.toCard() }).isCorrect()) {
            println(":)")
        } else {
            println(":(")
        }
    }
}

class CardCollector(private val cardList: List<Card>) {
    private val map = cardList.groupBy { it.alpha }
    fun isCorrect(): Boolean {
        return condition1() || condition2() || condition3()
    }

    private fun condition1(): Boolean {
        map.values.filter { it.size >= 3 }.forEach {
            if (it.map { it.num }.isContinuous())
                return true
        }
        return false
    }

    private fun condition2(): Boolean {
        for (card in cardList) {
            if (cardList.count { it == card } >= 3)
                return true
        }
        return false
    }

    private fun condition3(): Boolean {
        return cardList.map { card -> cardList.count { card == it } }.all { it == 2 }
    }

    private fun List<Int>.isContinuous(): Boolean {
        val compare = this.distinct().sorted().windowed(2).map { it[1] - it[0] }
        return when (compare.size) {
            2 -> compare.all { it == 1 }
            3 -> (compare[0] == 1 && compare[1] == 1) || (compare[1] == 1 && compare[2] == 1)
            else -> false
        }
    }
}

data class Card(val num: Int, val alpha: Char)

fun String.toCard() = Card(this[0].digitToInt(), this[1])