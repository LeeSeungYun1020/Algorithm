fun main() {
    val (N, M) = readln().split(" ").map { it.toLong() }
    val num = readln().split(" ").map { it.toInt() }
    var low = 0
    var high = 0
    var sum = 0L
    var count = 0
    while (true) {
        if (sum >= M) { // 합이 지정값보다 크거나 같으면 앞에 값 빼야 함
            sum -= num[low]
            low++
        } else if (high == N.toInt()) { // high가 범위 벗어난 경우 반복 종료
            break
        } else { // 합이 지정값보다 작은 경우, 다음 값 선택
            sum += num[high]
            high++
        }

        if (sum == M) {
            count++
        }
    }
    println(count)
}
