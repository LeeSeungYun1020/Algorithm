fun main() {
    val count = readLine()!!.toInt()
    for (i in 1..count){
        var open = 0
        for (c in readLine()!!){
            when (c) {
                '(' -> open++
                else -> open--
            }

            if (open < 0)
                break
        }
        when (open) {
            0 -> println("YES")
            else -> println("NO")
        }
    }
}