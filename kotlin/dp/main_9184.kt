fun main() {
    val array = Array(21) { Array(21) { IntArray(21) { 1 } } }
    for (i in 1..20) {
        for (j in 1..20) {
            for (k in 1..20) {
                array[i][j][k] = if (i < j && j < k)
                    array[i][j][k - 1] + array[i][j -1][k - 1] - array[i][j - 1][k]
                else
                    array[i - 1][j][k] + array[i - 1][j - 1][k] + array[i - 1][j][k - 1] - array[i - 1][j - 1][k - 1]
            }
        }
    }
    while (true) {
        val (a, b, c) = readLine()!!.split(' ').map { it.toInt() }
        if (a == -1 && b == -1 && c == -1)
            return
        print("w($a, $b, $c) = ")
        if (a <= 0 || b <= 0 || c <= 0)
            println(1)
        else if (a > 20 || b > 20 || c > 20)
            println(1048576)
        else
            println(array[a][b][c])
    }
}