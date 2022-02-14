fun main() {
    val (n, k) = readLine()!!.split(' ').map{ it.toInt() }
    var prev = (1..k).toList()
    val now = mutableListOf<Int>()

    for (i in 2..n){
        now.clear()
        now.add(1)
        for (j in 1 until k){
            now.add((now[j - 1] + prev[j]) % 1000000000)
        }
        prev = now.toList()
    }

    println(prev[k - 1])
}