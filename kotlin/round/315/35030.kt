import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val isPrime = MutableList(100_002) { it % 2 != 0 }
    isPrime[1] = false
    isPrime[2] = true
    isPrime[3] = true
    for (i in 3..317) {
        for (j in 3..100_002) {
            if (i * j >= 100_002) break
            isPrime[i * j] = false
        }
    }

    fun isSpecial(number: Int): Boolean {
        if (!isPrime[number + 1]) return false
        val digit = number.toString()
        for (cut in 0 until digit.lastIndex) {
            val start = digit.slice(0..cut)
            val end = digit.slice(cut + 1..digit.lastIndex)
            if (!isPrime[start.toInt() * end.toInt() + 1]) return false
        }
        return true
    }

    val specialSumList = MutableList(100_001) { 0 }
    for (i in 1..100_000) {
        specialSumList[i] = specialSumList[i - 1] + if (isSpecial(i)) 1 else 0
    }
    val br = BufferedReader(InputStreamReader(System.`in`))
    buildString {
        repeat(br.readLine().toInt()) {
            appendLine(specialSumList[br.readLine().toInt()])
        }
    }.run(::print)
}