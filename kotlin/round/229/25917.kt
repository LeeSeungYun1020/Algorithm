const val M = 998_244_353L
fun main() {
    val (r, c) = readln().split(" ").map { it.toLong() }
    // 소수 및 순서 정보는 계산에 필요 없음
    readln()
    readln()

    // 배치 가능한 경우의 수 계산
    // r * c 개를 c주머니로: (r*c) x (r*c-1) x ... x (r+1)
    // Ex: 6개를 3주머니: 6P2 x 4P2 x 2P2 = 6 x 5 x 4 x 3 x 1
    // Ex: 6개를 2주머니: 6P3 x 3P3 = 6 x 5 x 4 x 1
    println((r + 1..r * c).fold(1L) { acc, l ->
        acc * l % M
    })
}