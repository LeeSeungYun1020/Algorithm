data class Truck(val weight: Int, val leftTime: Int)
class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        val waitDeque = ArrayDeque<Int>()
        val bridgeDeque = ArrayDeque<Truck>()
        var time = 0
        var cars = 0
        var weights = 0
        waitDeque.addAll(truck_weights.toList())
        while (waitDeque.isNotEmpty()) {
            val first = waitDeque.removeFirst()
            if (weights + first <= weight && cars < bridge_length) {
                bridgeDeque.add(Truck(first, bridge_length + time))
                weights += first
                cars += 1
            } else {
                waitDeque.addFirst(first)
            }
            time++
            if (bridgeDeque.isNotEmpty()) {
                val truck = bridgeDeque.first()
                if (truck.leftTime <= time) {
                    bridgeDeque.removeFirst()
                    weights -= truck.weight
                    cars -= 1
                }
            }
        }
        return bridgeDeque.last().leftTime + 1
    }
}