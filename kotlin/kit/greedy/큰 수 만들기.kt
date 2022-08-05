class Solution {
    fun solution(number: String, k: Int): String {
        var answer = ""
        var index = -1
        // 남은 선택 갯수
        for (last in (number.length - k) downTo 1) {
            var max = 0.toChar()
            // 선택한 숫자 다음 숫자부터 찾기
            for (i in index + 1..number.length - last) {
                if (number[i] > max) {
                    index = i
                    max = number[i]
                }
            }
            answer += max
        }
        return answer
    }
}