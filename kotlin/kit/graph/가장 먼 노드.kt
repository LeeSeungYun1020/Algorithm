class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        // 메모리 초과 회피 위해 그래프에 해당 값을 넣고 순회하여 조회 (실행 시간은 증가)
        val graph = List(n) { mutableListOf<Int>() }
        for (e in edge) {
            graph[e[0] - 1].add(e[1] - 1)
            graph[e[1] - 1].add(e[0] - 1)
        }
        val visited = MutableList(n) { false }
        val deque = ArrayDeque<Pair<Int, Int>>()
        var mxLevel = 0
        var answer = 0
        visited[0] = true
        deque.add(0 to 0)
        while (deque.isNotEmpty()) {
            val (v, level) = deque.removeFirst()
            if (level == mxLevel)
                answer++
            else if (level > mxLevel) {
                mxLevel = level
                answer = 1
            }
            for (i in 0 until n) {
                if (i in graph[v] && !visited[i]) {
                    visited[i] = true
                    deque.add(i to level + 1)
                }
            }
        }
        return answer
    }
}