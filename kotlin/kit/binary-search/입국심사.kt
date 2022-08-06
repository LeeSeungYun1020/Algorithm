class Solution {
    fun solution(n: Int, times: IntArray): Long {
        // 우리가 구해야 하는 것은 시간
        // -> 최종 시간을 기준으로 심사관이 심사할 수 있는지를 확인한다.
        val sortedTimes = times.sorted()
        var answer: Long = 0
        // 시작 한 명도 심사하지 않는 경우는 없으므로 1초로 가정
        var start = 1L
        // 끝 최대 심사 시간은 가장 느린 심사관이 모둗 심사하는 경우
        var end = sortedTimes.last().toLong() * n
        while (start <= end) {
            val mid = (start + end) / 2
            // 모든 심사관이 심사한 사람의 수
            var people = 0L
            for (time in sortedTimes) {
                // 해당 심사관이 몇 명 심사할 수 있는가?
                people += mid / time
                if (people > n) { // 심사한 사람이 충분하다면
                    break
                }
            }
            if (people >= n) {
                // 심사한 사람이 충분한 경우 -> 시간 더 줄여도 가능한지 확인
                answer = mid
                end = mid - 1
            } else {
                // 심사한 사람이 부족한 경우 -> 시간 더 필요
                start = mid + 1
            }
        }
        return answer
    }
}