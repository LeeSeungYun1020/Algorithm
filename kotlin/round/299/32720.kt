const val MOD: Long = 1_000_000_007L

fun main() {
    val (n, k) = readln().split(" ").map { it.toLong() }

    if (n == 1L) {
        println(1)
        return
    }

    // s(i+1) - s(i) = p(i + k) - p(i) > 0 -> p(i + k) > p(i)
    // k개 수열로 나누는데 각 수열은 증가 수열
    val q = n / k
    val rem = n % k

    // 나눈 체인은 서로 섞을 수 있다.
    // answer = n! / q!^(k-rem) * (q+1)!^rem
    val factN = fact(n)
    val factQ = fact(q)
    val factQPlus1 = fact(q + 1)
    val denom = ((modPow(factQ, (k - rem)) % MOD) * modPow(factQPlus1, rem)) % MOD
    println((factN * modInv(denom)) % MOD)
}

fun fact(n: Long): Long {
    if (n <= 1L) return 1L
    var res = 1L
    var i = 2L
    while (i <= n) {
        res = (res * (i % MOD)) % MOD
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
