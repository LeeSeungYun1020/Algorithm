import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

fun main() {
    readln()
    val numbers = readln().split(' ').map { it.toInt() }

    val mx = numbers.maxOf { it } + 1
    val minPrime = MutableList(mx) { it }
    val sqrtMax = sqrt(mx.toDouble()).toInt()
    for (i in 2..sqrtMax) {
        if (minPrime[i] == i) {
            for (j in i * i until mx step i) {
                minPrime[j] = min(minPrime[j], i)
            }
        }
    }

    val root = MutableList(mx) { it }
    val size = MutableList(mx) { 0 }
    numbers.forEach { size[it]++ }

    fun find(x: Int): Int {
        if (root[x] == x) return x
        root[x] = find(root[x])
        return root[x]
    }

    fun merge(a: Int, b: Int) {
        val x = find(a)
        val y = find(b)
        if (x == y) return
        val mn = min(x, y)
        val mx = max(x, y)
        root[mx] = mn
        size[mn] += size[mx]
    }

    numbers.forEach { num ->
        var current = num
        while (current > 1) {
            val prime = minPrime[current]
            merge(num, prime)
            merge(prime, current)
            current /= prime
        }
    }
    println(size.maxOf { it })
}