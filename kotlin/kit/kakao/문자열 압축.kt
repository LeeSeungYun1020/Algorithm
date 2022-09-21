import kotlin.math.min

class Solution {
    fun solution(s: String): Int {
        var answer = s.length
        for (len in 1..s.length) {
            var prev = s.substring(0 until min(len, s.length))
            var count = s.length
            var sameCount = 1
            for (cut in len..s.length step len) {
                val comp = s.substring(cut until min(cut + len, s.length))
                if (prev == comp) {
                    count -= len
                    sameCount++
                } else {
                    if (sameCount > 1)
                        count += sameCount.toString().length
                    sameCount = 1
                }
                prev = comp
            }
            if (answer > count) {
                answer = count
            }
        }

        return answer
    }
}