import kotlin.math.sqrt

fun main() {
    val count = readLine()!!.toInt()
    val num = mutableListOf<Int>()
    for (i in 1..count){
        num.add(readLine()!!.toInt())
    }
    num.sort()
    val gcd = num.zipWithNext { a: Int, b: Int -> b - a }.reduce { gcd, n ->
        var a = gcd
        var b = n
        while (b != 0){
            val r = a % b
            a = b
            b = r
        }
        a
    }
    val ans = mutableSetOf<Int>()
    ans.add(gcd)
    for (i in 2..sqrt(gcd.toDouble()).toInt())
        if (gcd % i == 0){
            ans.add(i)
            ans.add(gcd / i)
        }
    ans.sorted().forEach{print("$it ")}
}