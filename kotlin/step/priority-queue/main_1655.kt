fun main() {
    val n = readLine()!!.toInt()
    val maxHeap = MaxHeap()
    val minHeap = MinHeap()
    for (i in 1..n) {
        val input = readLine()!!.toInt()
        if (maxHeap.size() == minHeap.size()) {
            maxHeap.add(input)
        } else {
            minHeap.add(input)
        }
        if (minHeap.size() > 0 && maxHeap.first() > minHeap.first()) {
            val mx = maxHeap.remove()
            val mn = minHeap.remove()
            maxHeap.add(mn)
            minHeap.add(mx)
        }
    }
}

class MaxHeap{
    private val array = IntArray(50000)
    private var lastIndex = -1

    fun add(input: Int) {
        array[++lastIndex] = input
        var prev = lastIndex
        var pos = (lastIndex - 1) / 2
        while (pos >= 0) {
            if (array[pos] < array[prev]) {
                val tem = array[pos]
                array[pos] = array[prev]
                array[prev] = tem
                prev = pos
                pos = (pos - 1) / 2
            } else break
        }
    }

    fun remove(): Int {
        when (lastIndex) {
            -1 -> return 0
            0 -> return array[lastIndex--]
        }
        val ans = array[0]
        array[0] = array[lastIndex--]
        var pos = 1
        var prev = 0
        while (pos <= lastIndex) {
            val maxPos = if (array[pos] < array.elementAtOrNull(pos + 1) ?: Int.MIN_VALUE) pos + 1 else pos
            if (array[maxPos] > array[prev]) {
                val tem = array[maxPos]
                array[maxPos] = array[prev]
                array[prev] = tem
                prev = maxPos
                pos = maxPos * 2 + 1
            } else break
        }
        return ans
    }

    fun first() = array[0]
    fun size() = lastIndex + 1
}

class MinHeap{
    private val array = IntArray(50000)
    private var lastIndex = -1

    fun add(input: Int) {
        array[++lastIndex] = input
        var prev = lastIndex
        var pos = (lastIndex - 1) / 2
        while (pos >= 0) {
            if (array[pos] > array[prev]) {
                val tem = array[pos]
                array[pos] = array[prev]
                array[prev] = tem
                prev = pos
                pos = (pos - 1) / 2
            } else break
        }
    }

    fun remove(): Int {
        when (lastIndex) {
            -1 -> return 0
            0 -> return array[lastIndex--]
        }
        val ans = array[0]
        array[0] = array[lastIndex--]
        var pos = 1
        var prev = 0
        while (pos <= lastIndex) {
            val minPos = if (array[pos] < array.elementAtOrNull(pos + 1) ?: Int.MAX_VALUE) pos else pos + 1
            if (array[minPos] < array[prev]) {
                val tem = array[minPos]
                array[minPos] = array[prev]
                array[prev] = tem
                prev = minPos
                pos = minPos * 2 + 1
            } else break
        }
        return ans
    }

    fun first() = array[0]
    fun size() = lastIndex + 1
}