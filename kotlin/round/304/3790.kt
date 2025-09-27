fun main() {
    buildString {
        repeat(readln().toInt()) {
            // 홀 (n - 1) / 2 * (n - 1) / 2
            // 짝 (n/2) * (n/2 - 1)
            readln().toInt().let { n -> (n / 2) * (n / 2 - if (n % 2 == 0) 1 else 0) }.run(::appendLine)
        }
    }.run(::print)
}