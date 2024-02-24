import kotlin.math.floor
import kotlin.math.roundToInt

fun main() {
    if (readln().isAkaPalindrome()) println("AKARAKA")
    else println("IPSELENTI")
}

fun String.isAkaPalindrome(): Boolean {
    if (length == 1) return true
    else {
        val len = floor(length.toDouble() / 2).roundToInt()
        return isPalindrome() && substring(0 until len).isAkaPalindrome() && substring(length - len..lastIndex).isAkaPalindrome()
    }
}

fun String.isPalindrome(): Boolean {
    var start = 0
    var end = lastIndex
    while (start < end) {
        if (get(start) != get(end)) return false
        start++
        end--
    }
    return true
}