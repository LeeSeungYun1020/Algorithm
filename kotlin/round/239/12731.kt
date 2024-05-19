import kotlin.math.max

fun main() {
    repeat(readln().toInt()) {
        val endTimeAppend = readln().toInt()
        val (numOfAToB, numOfBToA) = readNumbers()
        val aToB = readTimeTableList(numOfAToB, endTimeAppend)
        val bToA = readTimeTableList(numOfBToA, endTimeAppend)
        println("Case #${it + 1}: ${countCars(aToB, bToA)} ${countCars(bToA, aToB)}")
    }
}

class TimeTable(val departure: Int, val arrival: Int)

fun String.toMinutes(): Int = this.split(":").map { it.toInt() }.let { it[0] * 60 + it[1] }

fun readNumbers() = readln().split(" ").map { it.toInt() }
fun readTimeTableList(size: Int, endTimeAppend: Int): List<TimeTable> = if (size == 0) emptyList()
else List(size) {
    readln().split(" ").map { it.toMinutes() }.let { TimeTable(it[0], it[1] + endTimeAppend) }
}

fun countCars(departureTimeTableList: List<TimeTable>, arrivalTimeTableList: List<TimeTable>): Int {
    var numOfCars = 0
    (departureTimeTableList.map { it.departure to 1 } + arrivalTimeTableList.map { it.arrival to -1 }).sortedBy { it.first }
        .fold(0 to 0) { state, now ->
            if (state.first != now.first) {
                numOfCars = max(numOfCars, state.second)
            }
            now.first to (state.second + now.second)
        }.let {
            numOfCars = max(numOfCars, it.second)
        }
    return numOfCars
}