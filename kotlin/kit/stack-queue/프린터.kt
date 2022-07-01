data class Paper(val location: Int, val priority: Int)
class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val deque = ArrayDeque<Paper>()
        val temp = ArrayDeque<Paper>()
        for (i in 0..priorities.lastIndex) {
            deque.add(Paper(i, priorities[i]))
        }
        while (deque.isNotEmpty()) {
            val mx = deque.maxByOrNull { it.priority }
            while (true) {
                val first = deque.removeFirst()
                if (first.location == mx?.location) {
                    break
                } else {
                    deque.addLast(first)
                }
            }
            if (mx?.location == location) {
                return priorities.size - deque.size
            }
        }
        return priorities.size
    }
}