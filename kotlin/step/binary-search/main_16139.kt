fun main() {
    val input = readln()
    val indexListMap = buildMap<Char, MutableList<Int>> {
        for (alpha in 'a'..'z') this[alpha] = mutableListOf()
        for ((index, char) in input.withIndex()) this[char]?.add(index)
    }

    val numberOfQuestion = readln().toInt()
    for (i in 1..numberOfQuestion) {
        val (alpha, start, end) = readln().split(" ").parseQuery()
        val indexList = indexListMap[alpha] ?: emptyList<Int>()
        println(indexList.countEqualOrUnderByBinary(end) - indexList.countEqualOrUnderByBinary(start - 1))
    }
}

fun List<String>.parseQuery(): Triple<Char, Int, Int> = Triple(this[0][0], this[1].toInt(), this[2].toInt())

fun List<Int>.countEqualOrUnderByBinary(target: Int): Int {
    if (this.isEmpty() || target < this[0])
        return 0
    if (this.last() <= target)
        return this.size

    var min = 0
    var max = this.lastIndex
    while (min <= max) {
        val now = (min + max) / 2
        val num = this[now]
        when {
            target == num -> {
                return now + 1
            }
            target < num -> {
                max = now - 1
            }
            else -> {
                min = now + 1
            }
        }
    }
    return max + 1
}