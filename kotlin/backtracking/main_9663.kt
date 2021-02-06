import kotlin.math.absoluteValue

val arr = IntArray(14)
var n = 0
var ans = 0
fun main() {
    n = readLine()!!.toInt()
    searchPosition(0)
    print(ans)
}

fun searchPosition(depth: Int){
    if (depth == n) {
        ans++
    } else {
        for (i in 0 until n) {
            var pass = true
            for (j in 0 until depth) {
                if (arr[j] == i || (depth - j).absoluteValue == (i - arr[j]).absoluteValue) {
                    pass = false
                    break
                }
            }
            if (pass) {
                arr[depth] = i
                searchPosition(depth + 1)
            }
        }
    }
}