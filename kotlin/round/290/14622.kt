import java.util.*
import kotlin.math.sqrt

fun main() {
    val a = Person()
    val b = Person()
    repeat(readln().toInt()) {
        val (numA, numB) = readln().split(' ').map { it.toInt() }
        if (!numA.isPrime()) {
            b.addPoint()
        } else if (!a.contains(numA) && !b.contains(numA)) {
            a.submit(numA)
        } else {
            a.minusPoint()
        }
        if (!numB.isPrime()) {
            a.addPoint()
        } else if (!b.contains(numB) && !a.contains(numB)) {
            b.submit(numB)
        } else {
            b.minusPoint()
        }
    }
    if (a.point > b.point) {
        print("소수의 신 갓대웅")
    } else if (a.point < b.point) {
        print("소수 마스터 갓규성")
    } else {
        print("우열을 가릴 수 없음")
    }
}

const val MAX = 5_000_000
val isPrime = MutableList(MAX) { true }
fun initPrime() {
    isPrime[0] = false
    isPrime[1] = false

    val sqrtMax = sqrt(MAX.toDouble()).toInt()
    for (i in 2..sqrtMax) {
        if (isPrime[i]) {
            for (j in i * i until MAX step i) {
                isPrime[j] = false
            }
        }
    }
}

fun Int.isPrime(): Boolean {
    if (isPrime[0]) {
        initPrime()
    }
    return isPrime[this]
}

class Person {
    private var _point: Long = 0
    val point get() = _point
    private val top = TreeSet<Int>(Collections.reverseOrder())

    fun addPoint() {
        _point += top.elementAtOrElse(2) { 1000 }
    }

    fun minusPoint() {
        _point -= 1000
    }

    fun contains(num: Int) = top.contains(num)

    fun submit(num: Int) = top.add(num)
}