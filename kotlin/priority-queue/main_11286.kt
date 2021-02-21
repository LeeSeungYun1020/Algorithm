import kotlin.math.absoluteValue

fun main() {
    val n = readLine()!!.toInt()
    val pq = PriorityQue()
    for (i in 1..n) {
        val input = readLine()!!.toInt()
        if (input == 0)
            println(pq.remove())
        else
            pq.add(input)
    }
}

class PriorityQue{
    private val list = mutableListOf<Int>()

    fun add(input: Int) {
        list.add(input)
        var prev = list.lastIndex
        var pos = (list.lastIndex - 1) / 2
        while (pos >= 0) {
            val posVal = list[pos]
            val prevVal = list[prev]
            val posAbs = posVal.absoluteValue
            val prevAbs = prevVal.absoluteValue
            if (posAbs > prevAbs || (posAbs == prevAbs && posVal > prevVal)) {
                list[pos] = prevVal
                list[prev] = posVal
                prev = pos
                pos = (pos - 1) / 2
            } else break
        }
    }

    fun remove(): Int {
        when (list.size) {
            0 -> return 0
            1 -> return list.removeLast()
        }
        val ans = list[0]
        list[0] = list.removeLast()
        var pos = 1
        var prev = 0
        while (pos <= list.lastIndex) {
            val posVal = list[pos]
            val posAbs = posVal.absoluteValue
            val pos1Abs = list.elementAtOrNull(pos + 1)?.absoluteValue ?: Int.MAX_VALUE
            val minPos = if (posAbs < pos1Abs || (posAbs == pos1Abs && posVal < 0)) pos else pos + 1
            val minVal = list[minPos]
            val minAbs = minVal.absoluteValue
            val prevVal = list[prev]
            val prevAbs = prevVal.absoluteValue
            if (minAbs < prevAbs || (minAbs == prevAbs && minVal < prevVal)) {
                list[minPos] = prevVal
                list[prev] = minVal
                prev = minPos
                pos = minPos * 2 + 1
            } else break
        }
        return ans
    }
}