const val MOD = 1_000_000_007L

fun main() {
    readln()
    readln().split(" ")
        .map { it.toLong() }
        .fold(0L to 0L) { (acc, sum), input ->
            val n = ((acc + 1) % MOD * input % MOD) % MOD
            n to (sum + n) % MOD
        }
        .second
        .run(::println)
}