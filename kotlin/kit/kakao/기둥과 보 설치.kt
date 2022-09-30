data class Structure(val x: Int, val y: Int, val a: Int)

class Solution {
    private fun check(board: MutableList<Structure>): Boolean {
        for ((x, y, a) in board) {
            // 기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
            return if (a == 0) {
                if (y == 0 || board.contains(Structure(x - 1, y, 1)) || board.contains(Structure(x, y, 1))
                    || board.contains(Structure(x, y - 1, 0))
                ) {
                    continue
                } else
                    false
            }
            // 보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
            else {
                if (board.contains(Structure(x, y - 1, 0)) || board.contains(Structure(x + 1, y - 1, 0))
                    || ((board.contains(Structure(x - 1, y, 1)) && board.contains(Structure(x + 1, y, 1))))
                ) {
                    continue
                } else
                    false
            }
        }



        return true
    }

    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        val answer = mutableListOf<Structure>()
        for ((x, y, a, b) in build_frame) {
            // 삭제
            if (b == 0) {
                answer.remove(Structure(x, y, a))
                if (!check(answer)) {
                    answer.add(Structure(x, y, a))
                }
            }
            // 설치
            else {
                answer.add(Structure(x, y, a))
                if (!check(answer)) {
                    answer.remove(Structure(x, y, a))
                }
            }
        }
        return answer.sortedWith(compareBy(Structure::x, Structure::y, Structure::a))
            .map { intArrayOf(it.x, it.y, it.a) }.toTypedArray()
    }
}