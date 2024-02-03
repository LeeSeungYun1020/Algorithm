fun main() {
    val colleagues = List(readln().toInt()) {
        readln().split(" ")[1].split("-").map { it.toInt() }.toColleague()
    }.sortedBy { if (it.month < 10 || (it.month == 10 && it.day <= 28)) it.toNextDay() else it.toDay() }.distinct()

    var max = 0
    var answer = "00-00"
    (listOf(colleagues.last()) + colleagues).windowed(2) {
        it[0].diff(it[1])
    }.forEachIndexed { index, it ->
        if (max < it) {
            max = it
            answer = colleagues[index].toBeforeString()
        }
    }
    println(answer)
}

data class Colleague(val month: Int, val day: Int) {
    companion object {
        private val dayForMonth =
            listOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    }

    fun diff(other: Colleague): Int {
        val day = toDay()
        val otherDay = other.toDay()
        if (day < otherDay) {
            return otherDay - day
        } else {
            return other.toNextDay() - day
        }
    }

    fun toBeforeString(): String {
        return if (day == 1) {
            "%02d-%02d".format(if (month == 1) 12 else month - 1, dayForMonth[month + 11])
        } else {
            "%02d-%02d".format(month, day - 1)
        }
    }

    override fun toString(): String {
        return "%02d-%02d".format(month, day)
    }

    fun toDay(): Int = dayForMonth.slice(1 until month).sum() + day
    fun toNextDay(): Int = dayForMonth.slice(1 until (12 + month)).sum() + day
}

fun List<Int>.toColleague() = Colleague(get(0), get(1))