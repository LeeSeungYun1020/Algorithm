class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val typedClothes = mutableMapOf<String, Int>()
        for (clo in clothes) {
            val type = clo[1]
            typedClothes[type] = typedClothes.getOrDefault(type, 0) + 1
        }
        return typedClothes.values.map { it + 1 }.reduce { acc, i -> acc * i } - 1
    }
}