class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val expected = mutableMapOf<String, MutableList<Int>>()
        for (i in info) {
            val (lang, ground, work, food, point) = i.split(" ")
            for (str in listOf(
                "$lang$ground$work$food",
                "-$ground$work$food",
                "$lang-$work$food",
                "$lang$ground-$food",
                "$lang$ground$work-",
                "--$work$food",
                "-$ground-$food",
                "-$ground$work-",
                "$lang--$food",
                "$lang-$work-",
                "$lang$ground--",
                "---$food",
                "--$work-",
                "-$ground--",
                "$lang---",
                "----"
            )) {
                if (expected[str] != null)
                    expected[str]?.add(point.toInt())
                else
                    expected[str] = mutableListOf(point.toInt())
            }
        }
        for (key in expected.keys) {
            expected[key]?.sort()
        }

        val answer = IntArray(query.size) { 0 }
        for ((i, q) in query.withIndex()) {
            val (lang, ground, work, food, pointString) = q.split(" ").filterNot { it == "and" }
            val point = pointString.toInt()
            val points = expected["$lang$ground$work$food"] ?: continue
            var start = 0
            var end = points.lastIndex
            var mid = 0
            while (start <= end) {
                mid = (start + end) / 2
                if (points[mid] == point)
                    break
                if (points[mid] > point) {
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            }
            while (mid >= 0 && points[mid] >= point) {
                mid--
            }
            answer[i] = points.lastIndex - mid
        }
        return answer
    }
}