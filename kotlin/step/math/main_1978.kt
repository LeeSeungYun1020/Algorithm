fun main() {
    val pn = MutableList(1001) { it % 2 != 0 && it % 3 != 0 && it % 5 != 0 && it % 7 != 0 }
    pn[1] = false
    pn[2] = true
    pn[3] = true
    pn[5] = true
    pn[7] = true
    for (i in 11..1000 step 2){
        if (pn[i]) {
            for (j in 2..1000 / i)
                pn[i * j] = false
        }
    }
    readLine()
    println(readLine()!!.split(" ").count { pn[it.toInt()] })
}