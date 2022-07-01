class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = MutableList<Int>(commands.size) { 0 }
        for (i in 0 until commands.size) {
            answer[i] = array.slice(commands[i][0] - 1..commands[i][1] - 1).sorted()[commands[i][2] - 1]
        }
        return answer.toIntArray()
    }
}