fun main() {
    val t = readln().toInt()
    for (case in 1..t) {
        val n = readln().toInt()
        val coins = readln().split(" ").map { it.toInt() }
        val target = readln().toInt()

        val state = MutableList(target + 1) { 0 }
        state[0] = 1
        for (coin in coins) {
            for (i in coin..target) {
                state[i] += state[i - coin]
            }
        }
        println(state[target])
    }
}