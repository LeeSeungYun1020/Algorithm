import kotlin.math.absoluteValue
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    while (true) {
        val n = readln().toDouble()
        var p = 1
        val mx = sqrt(n.absoluteValue).toInt()
        when {
            n == 0.0 -> break
            n > 0 -> {
                top@
                for (i in 2..mx) {
                    for (j in 2..30) {
                        val tem = i.toDouble().pow(j.toDouble())
                        if (tem > n) break
                        else if (tem == n) {
                            p = j;
                            break@top
                        }
                    }
                }
            }
            else -> {
                top@
                for (i in -2 downTo -mx) {
                    for (j in 3..31 step 2) {
                        val tem = i.toDouble().pow(j.toDouble())
                        if (tem < n) break
                        else if (tem == n) {
                            p = j;
                            break@top
                        }
                    }
                }
            }
        }
        println(p)
    }
}