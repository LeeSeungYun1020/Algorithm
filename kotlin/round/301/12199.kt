import kotlin.math.min

const val MOD = 1000000007L

fun main() {
    val dp = List(101) { i -> MutableList(101) { if (i == 1) 1 else 0 } }
    fun find(key: Int, length: Int): Int {
        if (dp[key][length] != 0) return dp[key][length]
        var calc = key.toLong()
        repeat((1 until length).count()) { calc = mod(calc * key) }
        (1 until key).forEach { calc -= mod(combination(key.toLong(), it.toLong()) * find(it, length)) }
        dp[key][length] = mod(calc).toInt()
        return dp[key][length]
    }

    (1..readln().toInt()).joinToString("\n") {
        "Case #$it: ${readln().split(" ").map { it.toInt() }.let { (key, length) -> find(key, length) }}"
    }.run(::println)
}

fun combination(n: Long, r: Long): Long {
    val k = min(r, n - r)
    if (k == 0L) return 1L
    var res = 1L
    var i = 1L
    while (i <= k) {
        val numRaw = n - k + i
        val num = mod(numRaw, MOD)
        res = (res * num) % MOD
        val inv = modInv(i % MOD)
        res = (res * inv) % MOD
        i++
    }
    return res
}

fun mod(x: Long, mod: Long = MOD): Long {
    return ((x % mod) + mod) % mod
}

fun modInv(x: Long, mod: Long = MOD): Long {
    return modPow(x, mod - 2, mod)
}

fun modPow(base: Long, exp: Long, mod: Long = MOD): Long {
    var a = ((base % mod) + mod) % mod
    var e = exp
    var res = 1L
    while (e > 0) {
        if ((e and 1L) == 1L) res = (res * a) % mod
        a = (a * a) % mod
        e = e shr 1
    }
    return res
}