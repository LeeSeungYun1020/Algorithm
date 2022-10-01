import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.roundToInt

data class CarInOut(val carNumber: String, val inTime: Int, var outTime: Int = 23 * 60 + 59) {
    fun getStayTime(): Int {
        return outTime - inTime
    }

    fun calcFee(basicTime: Int, basicFee: Int, unitTime: Int, unitFee: Int): Int {
        var fee = basicFee
        if (getStayTime() > basicTime) {
            fee += ceil((getStayTime() - basicTime).toDouble() / unitTime).roundToInt() * unitFee
        }
        return fee
    }
}

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val (basicTime, basicFee, unitTime, unitFee) = fees
        val carInOutMap = mutableMapOf<String, CarInOut>()
        for (record in records) {
            val (time, number, inout) = record.split(" ")
            val (hour, minute) = time.split(":")
            val timeInMinute = hour.toInt() * 60 + minute.toInt()
            if (inout == "IN") {
                val carInOut = carInOutMap[number]
                // 첫 입차
                if (carInOut == null)
                    carInOutMap[number] = CarInOut(number, timeInMinute)
                // 출차 후 재입차
                else
                    carInOutMap[number] = CarInOut(number, timeInMinute - carInOut.getStayTime())
            } else {
                // 출차
                carInOutMap[number]?.outTime = timeInMinute
            }
        }

        var answer = IntArray(carInOutMap.size)
        carInOutMap.toSortedMap().values.forEachIndexed{i, carInOut ->
            answer[i] = carInOut.calcFee(basicTime, basicFee, unitTime, unitFee)
        }
        return answer
    }
}