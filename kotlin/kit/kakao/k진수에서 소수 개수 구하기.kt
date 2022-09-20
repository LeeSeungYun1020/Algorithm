import kotlin.math.sqrt

class Solution {
    fun isPrime(num: Long): Boolean {
        if (num == 1L) return false
        for (i in 2..sqrt(num.toDouble()).toLong()) {
            if (num % i == 0L) {
                return false
            }
        }
        return true
    }

    fun solution(n: Int, k: Int): Int {
        // step1: n을 k진수로 변환
        var t = ""
        var calc = n
        while (calc >= k) {
            t = "${calc % k}$t"
            calc /= k
        }
        t = "$calc$t"
        // step2: 0 기준 split
        val numbers = t.split("0").filterNot { it.isEmpty() }.map { it.toLong() }
        // step3: 소수인지 확인
        var answer = 0
        for (number in numbers) {
            if (isPrime(number))
                answer++
        }
        return answer
    }
}