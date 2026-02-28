fun main() {
    val n = readln().toInt() - 2
    val count = MutableList(4) { 0 }
    repeat(n) {
        when (readln()) {
            "0111" -> {
                count[1]++
                count[2] += 2
                count[3]++
            }
            "1011" -> {
                count[0]++
                count[2]++
                count[3] += 2
            }
            "1101" -> {
                count[0] += 2
                count[1]++
                count[3]++
            }
            "1110" -> {
                count[0]++
                count[1] += 2
                count[2]++
            }
        }
    }
    print(count.min() + n + 4)
}