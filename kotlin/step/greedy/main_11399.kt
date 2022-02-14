fun main() {
    readLine()
    var sum = 0
    var ans = 0
    readLine()!!.split(' ').map { it.toInt() }.sorted().forEach {
        sum += it
        ans += sum
    }
    print(ans)
}