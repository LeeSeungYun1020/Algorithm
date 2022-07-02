class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0

        fun dfs(level: Int, sum: Int) {
            if (level == numbers.size) {
                if (target == sum)
                    answer++
                return
            }
            dfs(level + 1, sum + numbers[level])
            dfs(level + 1, sum - numbers[level])
        }

        dfs(0, 0)

        return answer
    }
}