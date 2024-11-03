fun main() {
    readln()
    val record = readln().map { it == '#' }.toMutableList()

    var answer = Int.MAX_VALUE
    label@
    for (interval in 1..record.size) {
        var count = 0
        val valid = ArrayDeque<Int>()
        for ((index, isCry) in record.withIndex()) {
            val second = index + 1
            if (second < interval && isCry) {
                count++
                valid.addLast(index + interval)
            } else if (valid.firstOrNull() == index) {
                valid.removeFirst()
                if (isCry) { // 연장
                    valid.addLast(index + interval)
                }
            } else if (isCry) { // 신규
                count++
                valid.addLast(index + interval)
            }
            if (count >= answer) continue@label
        }
        answer = count
    }
    println(answer)
}