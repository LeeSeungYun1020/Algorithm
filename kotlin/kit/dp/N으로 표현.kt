class Solution {
    fun solution(N: Int, number: Int): Int {
        if (N == number)
            return 1
        val calc = MutableList(9) { mutableSetOf<Int>() }
        calc[1].add(N)
        var same = N
        for (i in 2..8) {
            same = same * 10 + N
            calc[i].add(same)
            for (j in 1..i - 1) {
                for (first in calc[j]) {
                    for (second in calc[i - j]) {
                        calc[i].apply {
                            add(first + second)
                            add(first - second)
                            add(first * second)
                            if (second != 0)
                                add(first / second)
                        }
                    }
                }
            }
            if (calc[i].contains(number)) {
                return i
            }
        }
        return -1
    }
}