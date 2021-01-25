fun main() {
    val pn = MutableList(10001) { true }
    pn[0] = false
    pn[1] = false
    for (i in 2..100) {
        if (pn[i])
            for (j in 2..(10000 / i)) {
                pn[i * j] = false
            }
    }
    val count = readLine()!!.toInt()
    for (i in 1..count){
        val num = readLine()!!.toInt()
        for (j in num/2 until num){
            if (pn[j] && pn[num - j]){
                println("${num - j} $j")
                break
            }
        }
    }
}