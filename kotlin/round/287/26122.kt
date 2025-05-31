import kotlin.math.*

fun main() {
    readln()
    var ans = 0
    var isN = true
    var n = 0
    var s = 0
    readln().forEach {
        if (it == 'N') {
            if (isN) { // N -> N
                n++
            }
            else { // S -> N
                ans = max(ans, min(s, n))
                n = 1
            }
            isN = true
        }
        else {
            if (isN) { // N -> S
                ans = max(ans, min(s, n))
                s = 1
            }
            else { // S -> S
                s++
            }
            isN = false
        }
    }
    ans = max(ans, min(s, n))
    println(ans shl 1)
}