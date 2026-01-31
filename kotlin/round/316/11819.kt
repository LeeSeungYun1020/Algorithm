fun main() {
    val (a, b, c) = readln().split(" ").map { it.toULong() }
    println(a.modPow(b, c))
}

private fun mulMod(a: ULong, b: ULong, mod: ULong): ULong {
    var x = a % mod
    var y = b
    var res = 0UL

    while (y != 0UL) {
        if ((y and 1UL) != 0UL) {
            res = if (res >= mod - x) res - (mod - x) else res + x
        }
        y = y shr 1
        if (y != 0UL) {
            x = if (x >= mod - x) x - (mod - x) else x + x
        }
    }
    return res
}

private fun ULong.modPow(exp: ULong, mod: ULong): ULong {
    if (mod == 1UL) return 0UL
    var b = this % mod
    var e = exp
    var res = 1UL % mod

    while (e != 0UL) {
        if ((e and 1UL) != 0UL) res = mulMod(res, b, mod)
        e = e shr 1
        if (e != 0UL) b = mulMod(b, b, mod)
    }
    return res
}