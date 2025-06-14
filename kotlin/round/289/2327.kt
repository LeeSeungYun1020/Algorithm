import kotlin.math.max
import kotlin.math.min

fun main() {
    val (sumOfHeight, numberOfStudents) = readln().split(" ").map { it.toInt() }
    val dp = MutableList(sumOfHeight + 1) { if (it == 0) 0 else -1 }
    val students = List(numberOfStudents) {
        readln().split(" ").map { it.toInt() }.let { Student(it[0], it[1]) }
    }
    students
        .forEach { student ->
            for (i in dp.lastIndex downTo 0) {
                if (i - student.height >= 0 && dp[i - student.height] != -1) {
                    dp[i] = max(
                        dp[i],
                        if (dp[i - student.height] == 0) student.speed else min(dp[i - student.height], student.speed)
                    )
                }
            }
        }
    println(dp.last())
}

class Student(val height: Int, val speed: Int)