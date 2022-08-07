class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        val board1 = List(n) { MutableList(n) { false } }
        val board2 = List(n) { MutableList(n) { false } }
        for (result in results) {
            board1[result[0] - 1][result[1] - 1] = true
            board2[result[1] - 1][result[0] - 1] = true
        }

        val count1 = MutableList(n) { 0 }
        val count2 = MutableList(n) { 0 }

        fun bfs1(start: Int) {
            val visited = MutableList(n) { false }
            val deque = ArrayDeque<Int>()
            deque.add(start)
            while (deque.isNotEmpty()) {
                val current = deque.removeFirst()
                for (i in 0 until n) {
                    if (board1[current][i] && !visited[i]) {
                        visited[i] = true
                        count1[i]++
                        deque.add(i)
                    }
                }
            }
        }

        fun bfs2(start: Int) {
            val visited = MutableList(n) { false }
            val deque = ArrayDeque<Int>()
            deque.add(start)
            while (deque.isNotEmpty()) {
                val current = deque.removeFirst()
                for (i in 0 until n) {
                    if (board2[current][i] && !visited[i]) {
                        visited[i] = true
                        count2[i]++
                        deque.add(i)
                    }
                }
            }
        }

        for (i in 0 until n) {
            bfs1(i)
            bfs2(i)
        }
        for (i in 0 until n) {
            if (count1[i] + count2[i] == n - 1) {
                answer++
            }
        }
        return answer
    }
}