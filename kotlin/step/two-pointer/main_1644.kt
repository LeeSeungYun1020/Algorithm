fun main() {
    val N = readln().toInt()
    when(N) {
        1 -> {
            println(0)
            return
        }
        2 -> {
            println(1)
            return
        }
    }
    val prime = MutableList(N + 1) { it % 2 != 0 && it % 3 != 0 }
    prime[1] = false
    prime[2] = true
    prime[3] = true
    for (i in 5..N) {
        if (prime[i]) {
            for (j in 2..N)
                if (i * j <= N)
                    prime[i * j] = false
                else break
        }
    }

    var count = 0
    var end = 0
    var sum = 0
    for (start in 0..N) {
        while (sum < N && end <= N) {
            if (prime[end])
                sum += end
            end++
        }

        if (sum == N && prime[start] && prime[end-1])
            count++

        if (prime[start])
            sum -= start
    }
    println(count)
}
