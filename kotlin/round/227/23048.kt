import kotlin.math.sqrt

fun main() {
    val n = readln().toInt()
    // if 1
    if (n == 1) {
        println(1)
        println(1)
        return
    }
    // init
    val prime = MutableList(n + 1) { ColorInt(true, 1) }
    var count = 1
    prime[1].isPrime = false
    // coloring with prime
    val mx = sqrt(n.toDouble()).toInt() + 1
    for (i in 2..mx) {
        if (prime[i].isPrime) {
            count++
            prime[i].color = count
            for (j in (i + i)..n step i) {
                prime[j].apply {
                    isPrime = false
                    color = count
                }
            }
        }
    }
    // coloring remains
    for (i in (mx + 1)..n) {
        if (prime[i].isPrime) {
            count++
            prime[i].color = count
        }
    }
    // print result
    prime.removeFirst()
    println(count)
    println(prime.joinToString(separator = " ") { it.color.toString() })
}

data class ColorInt(var isPrime: Boolean, var color: Int)