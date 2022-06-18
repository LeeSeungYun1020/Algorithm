class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        val target = progresses.lastIndex
        var now = 0
        while (now <= target) {
            for (i in now..progresses.lastIndex) {
                if (progresses[i] < 100)
                    progresses[i] += speeds[i]
            }
            var count = 0
            for (i in now..progresses.lastIndex) {
                if (progresses[i] >= 100)
                    count++
                else
                    break
            }
            if (count != 0) {
                now += count
                answer.add(count)
            }
        }
        return answer.toIntArray()
    }
}