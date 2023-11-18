fun main() {
    val input = readln().split(" ")
    val level = input[0].toInt()
    val eat = input[1].toLong() - 1

    val sizeByLevel = buildList<Long> {
        add(1)
        repeat(level) {
            add(3 + last() * 2)
        }
    }
    val pByLevel = buildList<Long> {
        add(1)
        repeat(level) {
            add(1 + last() * 2)
        }
    }

    fun find(level: Int, index: Long): Long {
        if (level == 0) return 1
        val size = sizeByLevel[level]
        val half = size / 2
        val prevSize = sizeByLevel[level - 1]
        val prevP = pByLevel[level - 1]
        return when (index) {
            0L -> {
                0
            }
            half -> {
                prevP + 1
            }
            size - 1 -> {
                prevP * 2 + 1
            }
            in 1 until half -> {
                find(level - 1, index - 1)
            }
            else -> {
                prevP + 1 + find(level - 1, index - prevSize - 2)
            }
        }
    }

    println(find(level, eat))
}