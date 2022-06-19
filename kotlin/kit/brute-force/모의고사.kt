class Solution {
    fun solution(answers: IntArray): IntArray {
        val case1 = listOf(1, 2, 3, 4, 5)
        val case2 = listOf(2, 1, 2, 3, 2, 4, 2, 5)
        val case3 = listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        val case1Size = case1.size
        val case2Size = case2.size
        val case3Size = case3.size
        var count = mutableListOf(0, 0, 0)
        for (i in 0..answers.lastIndex) {
            val answer = answers[i]
            if (case1[i % case1Size] == answer)
                count[0]++
            if (case2[i % case2Size] == answer)
                count[1]++
            if (case3[i % case3Size] == answer)
                count[2]++
        }
        val mx = count.indexOf(count.maxOf { it })
        if (count[0] == count[1] && count[0] == count[2])
            return intArrayOf(1, 2, 3)
        if (mx == 0 && count[0] == count[1])
            return intArrayOf(1, 2)
        if (mx == 0 && count[0] == count[2])
            return intArrayOf(1, 3)
        if (mx == 1 && count[1] == count[2])
            return intArrayOf(2, 3)
        return intArrayOf(mx + 1)
    }
}
