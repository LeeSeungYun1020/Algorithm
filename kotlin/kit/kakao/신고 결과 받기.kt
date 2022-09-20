class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val user = id_list.mapIndexed { index, s -> s to index }.toMap()
        val board = List(id_list.size) { MutableList(id_list.size) { false } }
        for (data in report) {
            val (a, b) = data.split(" ")
            board[user[a]!!][user[b]!!] = true
        }
        val fired = MutableList(id_list.size) { 0 }
        for (i in board.indices) {
            for (j in board.indices) {
                if (board[i][j]) {
                    fired[j]++
                }
            }
        }

        val answer = IntArray(id_list.size)
        for ((i, f) in fired.withIndex()) {
            if (f >= k) {
                for (j in id_list.indices) {
                    if (board[j][i]) {
                        answer[i]++
                    }
                }
            }
        }
        return answer
    }
}