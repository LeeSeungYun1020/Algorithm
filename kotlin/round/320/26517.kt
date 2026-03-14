fun main() {
    val k = readln().toLong()
    val (a, b, c, d) = readln().split(" ").map { it.toLong() }
    val left = a * k + b
    val right = c * k + d
    print(if (left == right) "Yes $left" else "No")
}