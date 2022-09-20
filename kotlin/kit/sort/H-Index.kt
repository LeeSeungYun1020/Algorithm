class Solution {
    fun solution(citations: IntArray): Int {
        val sortedCitations = citations.sorted()
        for (i in sortedCitations.indices) {
            // 인용된 논문의 수
            val hIndex = citations.size - i
            // h번 이상 인용되었으면
            if (sortedCitations[i] >= hIndex)
                return hIndex
        }
        return 0
    }
}