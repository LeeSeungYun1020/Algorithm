data class Status(val sheep: Int, val wolf: Int)

class Solution {
    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        val table = List(info.size) { MutableList(info.size) { false } }
        for (edge in edges) {
            table[edge[0]][edge[1]] = true
        }

        val visited = MutableList(info.size) { false }
        var mx = 1
        fun dfs(status: Status, pos: List<Int>) {
            if (status.sheep <= status.wolf)
                return
            if (status.sheep > mx)
                mx = status.sheep
            for (i in info.indices) {
                for (position in pos) {
                    if (table[position][i] && !visited[i]) {
                        visited[i] = true
                        if (info[i] == 0)
                            dfs(Status(status.sheep + 1, status.wolf), pos + i)
                        else
                            dfs(Status(status.sheep, status.wolf + 1), pos + i)
                        visited[i] = false
                    }
                }

            }
        }
        visited[0] = true
        dfs(Status(1, 0), listOf(0))
        return mx
    }
}