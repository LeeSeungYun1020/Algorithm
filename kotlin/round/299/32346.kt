import kotlin.math.min

const val MOD: Long = 1_000_000_007L

fun main() {
    readln()
    val str = readln()

    var answer = 0L
    var current = str.findIndex(0)
    while (current < str.length) {
        var level = 0
        while (str.isExpandable(current, level)) {
            val pre = current.toLong() - level
            val suf = str.lastIndex.toLong() - current - 1 - level
            answer += combination(pre + suf, pre)
            answer %= MOD
            level++
        }
        current = str.findIndex(current + 1)
    }
    println(answer)
}

fun String.findIndex(start: Int): Int {
    for (i in start until lastIndex) {
        if (isExpandable(i, 0)) return i
    }
    return length
}

fun String.isExpandable(start: Int, level: Int): Boolean {
    return getOrNull(start - level) == '>' && getOrNull(start + 1 + level) == '<'
}

fun combination(n: Long, r: Long): Long {
    val k = min(r, n - r)
    if (k == 0L) return 1L
    var res = 1L
    var i = 1L
    while (i <= k) {
        val numRaw = n - k + i
        val num = ((numRaw % MOD) + MOD) % MOD
        res = (res * num) % MOD
        val inv = modInv(i % MOD)
        res = (res * inv) % MOD
        i++
    }
    return res
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
