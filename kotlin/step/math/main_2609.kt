import kotlin.math.min

fun main() {
    val (numA, numB) = readLine()!!.split(' ').map { it.toInt() }
    var a = numA
    var b = numB
    var gcd = 1
    var i = 2
    while (i <= min(a, b)){
        if (a % i == 0 && b % i == 0){
            gcd *= i
            a /= i
            b /= i
        } else {
            i++
        }
    }
    println(gcd)
    println(numA / gcd * numB)
}