fun main() {
    val (n, length) = readln().split(" ").map { it.toInt() }
    val pos = readln().split(" ").map { it.toInt() }.sorted()

    var ans = 0
    var cover = -length - 1
    for (p in pos) {
        if (p < cover)
            continue

        ans++
        cover = p + length
    }
    println(ans)
}