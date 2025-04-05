fun main() {
    var (_, numberOfJobs) = readln().split(" ").map { it.toInt() }
    readln().map {
        val need = 'Z' - it + 1
        if (numberOfJobs >= need && it != 'A') {
            numberOfJobs -= need
            'A'
        } else it
    }.run {
        if (numberOfJobs == 0) {
            this
        } else {
            val last = ((last().code - 'A'.code + numberOfJobs) % ('Z' - 'A' + 1) + 'A'.code).toChar()
            dropLast(1) + last
        }.joinToString(separator = "")
    }.run { println(this) }
}