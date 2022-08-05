import java.lang.Integer.min

class Solution {
    private fun changeable(str1: String, str2: String): Boolean {
        var count = 0
        for (i in str1.indices) {
            if (str1[i] != str2[i]) {
                count++
            }
            if (count > 1) {
                return false
            }
        }
        if (count == 1) {
            return true
        }
        return false
    }

    fun solution(begin: String, target: String, words: Array<String>): Int {
        if (target !in words)
            return 0
        val visited = MutableList(words.size) { false }
        var answer = Int.MAX_VALUE
        fun dfs(now: String, level: Int) {
            if (now == target)
                answer = min(answer, level)
            else
                for ((i, word) in words.withIndex()) {
                    if (!visited[i] && changeable(now, word)) {
                        visited[i] = true
                        dfs(word, level + 1)
                        visited[i] = false
                    }
                }
        }
        dfs(begin, 0)

        return if (answer == Int.MAX_VALUE)
            0
        else
            answer
    }
}