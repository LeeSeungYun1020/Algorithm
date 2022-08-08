class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        val sortedTickets = tickets.sortedBy { it[1] }
        var answer = Array<String>(sortedTickets.size + 1) { "ICN" }
        val start = "ICN"
        val visited = MutableList(sortedTickets.size) { false }
        fun dfs(prev: String, level: Int): Boolean {
            if (level == sortedTickets.size) {
                return true
                // 더이상 반복 진행되면 안됨...
            }
            for (i in sortedTickets.indices) {
                if (sortedTickets[i][0] == prev && !visited[i]) {
                    visited[i] = true
                    answer[level + 1] = sortedTickets[i][1]
                    if (dfs(sortedTickets[i][1], level + 1))
                        return true
                    visited[i] = false
                }
            }
            return false
        }
        dfs(start, 0)

        return answer
    }
}

fun main() {
    val solution = Solution()
    println(
        "Ans " + solution.solution(
            arrayOf(arrayOf("ICN", "SFO"), arrayOf("ICN", "ATL"), arrayOf("SFO", "ATL"), arrayOf("ATL", "ICN"), arrayOf("ATL", "SFO"))
        ).toList()
    )
}