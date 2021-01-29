fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    var up = 1
    var down = 1
    for (i in 2..n){
        if (i > k)
            up *= i
        if (i <= n - k)
            down *= i
    }
    println(up / down)
}