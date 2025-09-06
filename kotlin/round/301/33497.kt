import kotlin.math.min

fun main() {
    val (numberOfStudents, numberOfDays) = readln().split(" ").map { it.toInt() }
    val usePass = MutableList(numberOfStudents) { false }
    var passUsage = numberOfStudents
    val schedule = List(numberOfDays) { readln().split(" ").map { it.toInt() }.let { it[0] to it[1] } }
    val attendance = List(numberOfDays) { MutableList(numberOfStudents) { '-' } }

    schedule.forEachIndexed { i, (day, night) ->
        val attendance = attendance[i]
        if (numberOfStudents < day + night) {
            println("NO")
            return
        }
        var availablePassUsage = min(numberOfStudents - day - night, passUsage)
        var dayCount = day
        for (i in attendance.indices) {
            if (availablePassUsage > 0 && !usePass[i]) {
                availablePassUsage--
                usePass[i] = true
                passUsage--
                attendance[i] = 'X'
            } else if (dayCount > 0) {
                dayCount--
                attendance[i] = '+'
            }
        }
    }
    if (passUsage > 0) {
        println("NO")
        return
    }
    println("YES")
    (0 until numberOfStudents)
        .joinToString("\n") { id -> attendance.joinToString("") { it[id].toString() } }
        .run(::println)
}