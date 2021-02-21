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
            if (list[pos] < list[prev]) {
                val tem = list[pos]
                list[pos] = list[prev]
                list[prev] = tem
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
            val maxPos = if (list[pos] < list.elementAtOrNull(pos + 1) ?: 0) pos + 1 else pos
            if (list[maxPos] > list[prev]) {
                val tem = list[maxPos]
                list[maxPos] = list[prev]
                list[prev] = tem
                prev = maxPos
                pos = maxPos * 2 + 1
            } else break
        }
        return ans
    }
}