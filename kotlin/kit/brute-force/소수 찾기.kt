class Solution {
    var calculated = false
    val primes = MutableList(10000000) { it % 2 != 0 }
    fun isPrime(n: Int): Boolean {
        if (!calculated) {
            primes[1] = false
            primes[2] = true
            for (i in 3 until 10000000) {
                if (primes[i]) {
                    for (j in 3 until 10000000) {
                        val k = i * j
                        if (k < 10000000)
                            primes[k] = false
                        else
                            break
                    }
                }
            }

            calculated = true
        }
        return primes[n]
    }

    fun solution(numbers: String): Int {
        val number = numbers.map { it.digitToInt() }
        val visited = MutableList(number.size) { false }
        val created = mutableSetOf<Int>()
        var ans = 0

        fun dfs(num: Int, level: Int) {
            if (level >= number.size) {
                created.add(num)
            } else {
                dfs(num, level + 1)
                for ((i, n) in number.withIndex()) {
                    if (!visited[i]) {
                        visited[i] = true
                        dfs(num * 10 + n, level + 1)
                        visited[i] = false
                    }
                }
            }
        }
        dfs(0, 0)
        println(created)
        for (c in created) {
            if (isPrime(c))
                ans++
        }
        return ans
    }
}