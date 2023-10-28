fun main() {
    val (start, end) = readln().split(" ").map { it.toMinute() }
    val (numberOfPreviousPackage, timePerPackage) = readln().split(" ").map { it.toInt() }

    var numberOfPackage = numberOfPreviousPackage
    var day = 0
    var now = start
    while (numberOfPackage >= 0) {
        if (now + timePerPackage >= end) {
            day++
            now = start
            continue
        }
        now += timePerPackage
        numberOfPackage--
    }
    println(day)
    println(now.toTimeString())
}

fun String.toMinute() = this.split(":").map { it.toInt() }.let {
    it[0] * 60 + it[1]
}

fun Int.toTimeString() = "${"%02d".format(this / 60)}:${"%02d".format(this % 60)}"
