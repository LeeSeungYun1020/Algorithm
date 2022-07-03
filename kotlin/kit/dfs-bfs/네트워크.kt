class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val visited = MutableList(n) { 0 }

        fun dfs(pos: Int, type: Int) {
            for (i in 0 until n) {
                if (computers[pos][i] == 1 && visited[i] == 0) {
                    visited[pos] = type
                    dfs(i, type)
                }
            }
        }

        for (i in 0 until n) {
            if (visited[i] == 0) {
                answer += 1
                visited[i] = answer
                dfs(i, answer)
            }

        }

        return answer
    }
}