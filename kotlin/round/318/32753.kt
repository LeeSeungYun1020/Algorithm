fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    if (n == 1) {
        print("1 ".repeat(k).trimEnd())
    } else if (n == 2 && k == 1) {
        print("1 2")
    } else {
        print(-1)
    }
}