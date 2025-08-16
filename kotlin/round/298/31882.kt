fun main() {
    readln()
    readln().split("[013456789]+".toRegex()).sumOf {
        val n = it.count().toLong()
        n * (n + 1) * (n + 2) / 6
    }.run(::println)
}