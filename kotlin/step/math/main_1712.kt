import kotlin.math.ceil

fun main() {
    val (a,b,c) = readLine()!!.split(" ").map { it.toInt() }
    if (c - b <= 0)
        print(-1)
    else{
        val ans = ceil(a.toDouble() / (c - b)).toInt()
        if (ans * (c-b) == a)
            print(ans + 1)
        else
            print(ans)
    }
}