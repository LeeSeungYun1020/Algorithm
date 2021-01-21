import kotlin.math.max

fun main() {
    val count = readLine()!!.toInt()
    for (i in 1..count){
        val len = readLine()!!.toInt()
        val up = readLine()!!.split(" ").map { it.toInt() }
        val down = readLine()!!.split(" ").map { it.toInt() }
        val dpUp = mutableListOf(up.first())
        val dpDown = mutableListOf(down.first())
        var m = max(up.first(), down.first())

        if (len > 1){
            dpUp.add(down[0] + up[1])
            dpDown.add(up[0] + down[1])
            m = max(m, max(dpUp[1], dpDown[1]))
        }

        for (j in 2 until len){
            dpUp.add(max(dpDown[j - 2] + up[j], dpDown[j - 1] + up[j]))
            dpDown.add(max(dpUp[j - 2] + down[j], dpUp[j - 1] + down[j]))
            m = max(m, max(dpUp[j], dpDown[j]))
        }
        println(m)
    }
}