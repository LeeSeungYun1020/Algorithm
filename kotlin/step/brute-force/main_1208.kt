fun main() {
    val (N, S) = readln().split(" ").map { it.toInt() }
    val num = readln().split(" ").map { it.toInt() }.sorted()

    var count = 0L
    val subsum = mutableMapOf<Int, Int>()
    val mx = N/2
    fun halfDfs(level: Int, sum: Int) {
        if (level == mx) {
            subsum[sum] = subsum.getOrDefault(sum, 0) + 1
            return
        }
        halfDfs(level+1, sum + num[level])
        halfDfs(level+1, sum)
    }
    fun lastDfs(level: Int, sum: Int) {
        if (level == N) {
            count += subsum.getOrDefault(S-sum, 0)
            return
        }
        lastDfs(level+1, sum + num[level])
        lastDfs(level+1, sum)
    }
    halfDfs(0, 0)
    lastDfs(mx, 0)
    if (S == 0)
        count--
    println(count)
}
