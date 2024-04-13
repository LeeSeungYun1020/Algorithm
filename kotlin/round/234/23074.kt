fun main() {
    val n = readln().toInt()
    // 2의 배수 기준 끊고 k(2n)와 k+1(2n+1)은 무조건 서로소이므로 같은 색상 칠해도 됨
    println((n / 2).coerceAtLeast(1))
    print(buildString {
        for (i in 1..n) {
            append("${(i / 2).coerceAtLeast(1)} ")
        }
    })
}