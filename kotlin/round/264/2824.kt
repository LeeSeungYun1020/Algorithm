import kotlin.math.min

fun main() {
    readln()
    val listA = readln().split(" ").map { it.toInt() }
    readln()
    val listB = readln().split(" ").map { it.toInt() }

    val size = 31623 // 31622.776601683792
    val isPrime = MutableList(size) { true }
    val prime = mutableListOf<Int>()
    isPrime[1] = false
    for (i in 2 until size) {
        if (isPrime[i]) {
            prime.add(i)
            for (j in i * i until size step i) {
                isPrime[j] = false
            }
        }
    }

    val factorA = mutableMapOf<Int, Int>()
    val factorB = mutableMapOf<Int, Int>()
    fun factorization(num: Int, action: (Int) -> Unit) {
        var calc = num
        for (p in prime) {
            while (calc % p == 0) {
                calc /= p
                action(p)
            }
        }
        if (calc != 1) action(calc)
    }
    listA.forEach { factorization(it) { factorA[it] = factorA.getOrDefault(it, 0) + 1 } }
    listB.forEach { factorization(it) { factorB[it] = factorB.getOrDefault(it, 0) + 1 } }

    (factorA.keys intersect factorB.keys).map { it to min(factorA.getOrDefault(it, 0), factorB.getOrDefault(it, 0)) }
        .fold(1L to false) { (acc, isOver), (num, count) ->
            var calc = acc
            var over = isOver
            repeat(count) {
                calc *= num
                if (calc >= 1000000000) {
                    calc %= 1000000000
                    over = true
                }
            }
            calc to over
        }.let { (answer, isOVer) ->
            if (isOVer) {
                println("%09d".format(answer))
            } else {
                println(answer)
            }
        }
}