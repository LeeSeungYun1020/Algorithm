import kotlin.math.max

fun main() {
    val input = readLine()!!.split("\n")
    val count = input[0].toInt()
    for (i in 0 until count){
        val len = input[1 + 3 * i].toInt()
        val up = input[2 + 3 * i].split(" ").map { it.toInt() }
        val down = input[3 + 3 * i].split(" ").map { it.toInt() }
        val dpUp = mutableListOf(up[0])
        val dpDown = mutableListOf(down[0])
        var m = max(up[0], down[0])

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