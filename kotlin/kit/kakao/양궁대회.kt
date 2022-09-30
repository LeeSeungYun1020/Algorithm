class Solution {
    fun solution(n: Int, info: IntArray): IntArray {
        val appeach = info.toList()
        val lion = MutableList(11) { 0 }
        var ans: List<Int>? = null
        var mx = 0
        fun dfs(score: Int, left: Int, level: Int) {
            if (level == 11) {
                lion[10] += left
                if (score > mx) {
                    mx = score
                    ans = lion.toList()
                }
                if (score == mx && ans != null) {
                    for (i in 10 downTo 0) {
                        if (lion[i] == ans!![i])
                            continue
                        if (lion[i] > ans!![i]) {
                            ans = lion.toList()
                        }
                        break
                    }
                }
                return
            }

            // appeach보다 1개 많이 사용
            if (left > appeach[level]) {
                lion[level] = appeach[level] + 1
                dfs(score + 10 - level, left - appeach[level] - 1, level + 1)
                lion[level] = 0
            }
            // 사용X하고 넘김
            // 어피치가 이긴 경우
            if (appeach[level] > 0) {
                dfs(score - 10 + level, left, level + 1)
                lion[level] = 0
            } else {
                dfs(score, left, level + 1)
                lion[level] = 0
            }
        }
        dfs(0, n, 0)

        if (ans != null && mx > 0) {
            return ans!!.toIntArray()
        }
        return intArrayOf(-1)
    }
}