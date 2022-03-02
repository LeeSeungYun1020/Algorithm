fun main() {
    val n = readLine()!!.toInt()
    val word = List(n) { readLine()!! }.sortedBy { it.length }.toSet()
    val ans = word.toMutableList()
    for (i in word) {
        for (j in word) {
            if (i != j && i.startsWith(j)) {
                ans.remove(j)
            }
        }
    }
    println(ans.size)
}