class Solution {
    fun solution(n: Int, times: IntArray): Long {
        val sortedTimes = times.sorted()
        // 우리가 구해야 하는 것은 시간 -> 최종 시간을 기준으로 심사관이 심사할 수 있는지를 확인한다.
        var answer: Long = 0
        var start = 1L
        var end = sortedTimes.last().toLong() * n
        while (start <= end) {
            val mid = (start + end) / 2
            var people = 0L
            for (time in sortedTimes) {
                people += mid / time
                if (people > n) {
                    break
                }
            }
            if (people >= n) {
                answer = mid
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        return answer
    }
}