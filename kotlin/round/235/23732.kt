fun main() {
    val length = readln().toInt()
    val word = readln()

    if (length < 2) {
        println(0)
        return
    }

    var start = 0
    var end = 1
    var prev = word[start]
    var count = 0L
    while (end < length) {
        if (prev == word[end]) {
            count += (length - end) * (end - start)
            start = end
            end++
        } else {
            prev = word[end]
            end++
        }
    }
    println(count)
}