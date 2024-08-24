fun main() {
    val (height, second) = readln().split(" ").map { it.toLong() }
    val save = mutableMapOf<Long, Long>()

    fun calculate(): Long {
        val accumulator = mutableMapOf<Long, Long>()
        var tem = height
        var times = 0L
        while (times < second) {
            if (accumulator.containsKey(tem)) {
                val length = times - accumulator.getValue(tem)
                var index = (second - times) % length
                if (index == 0L) return tem
                else {
                    while (index-- > 0L) {
                        tem = save.getValue(tem)
                    }
                    return tem
                }
            }
            accumulator[tem] = times++
            val move = when {
                save.containsKey(tem) -> save.getValue(tem)
                tem % 2 == 0L -> tem.shr(1).xor(6)
                else -> tem.shl(1).xor(6)
            }
            save[tem] = move
            tem = move
        }
        return tem
    }

    println(calculate())
}