class Solution {
    fun solution(numbers: IntArray): String {
        val sortedNumbers = numbers.map { it.toString() }.sortedByDescending {
            it.repeat(3)
        }
        var result = sortedNumbers.joinToString("")
        while (result.startsWith("0") && result.length > 1) {
            result = result.removePrefix("0")
        }
        return result
    }
}