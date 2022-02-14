fun main() {
    val input = getInt()
    if(input % 5 == 0)
        return println(input / 5)

    var five = input / 5
    while(five >= 0) {
        val left = input - five * 5
        if(left % 3 == 0)
            return println(five + left / 3)
         else
            five--
    }
    return println(-1)
}

fun getInt() = readLine()?.toInt() ?: 0