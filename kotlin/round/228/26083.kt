import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// enum 사용 시 시간 초과
const val INVALID = 0
const val SAFE = 1
const val UNSAFE = 2

fun main() {
    // 표준 입출력 사용 시 시간 초과
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (currentYear, currentMonth, currentDate) = br.readLine().split(" ").map { it.toInt() }

    fun isSafeDate(
        year: Int,
        month: Int,
        date: Int,
    ): Int {
        // Check range
        // month range check
        if (month !in 1..12) return INVALID
        // date range check
        if (date !in 1..when (month) {
                1, 3, 5, 7, 8, 10, 12 -> 31
                2 -> {
                    if (year % 4 == 0) 29 else 28
                }
                else -> 30
            }
        ) return INVALID

        // Compare
        return when {
            currentYear < year -> SAFE
            currentYear == year -> {
                when {
                    currentMonth < month -> SAFE
                    currentMonth == month -> {
                        when {
                            currentDate < date -> SAFE
                            currentDate == date -> SAFE
                            else -> UNSAFE
                        }
                    }
                    else -> UNSAFE
                }
            }
            else -> UNSAFE
        }
    }

    repeat(br.readLine().toInt()) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        var count = 0
        when (isSafeDate(a, b, c)) {
            INVALID -> {}
            SAFE -> count++
            UNSAFE -> {
                bw.write("unsafe\n")
                return@repeat
            }
        }
        when (isSafeDate(c, b, a)) {
            INVALID -> {}
            SAFE -> count++
            UNSAFE -> {
                bw.write("unsafe\n")
                return@repeat
            }
        }
        when (isSafeDate(c, a, b)) {
            INVALID -> {}
            SAFE -> count++
            UNSAFE -> {
                bw.write("unsafe\n")
                return@repeat
            }
        }
        if (count > 0) {
            bw.write("safe\n")
        } else {
            bw.write("invalid\n")
        }
    }
    bw.flush()
    bw.close()
}