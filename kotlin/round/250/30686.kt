fun main() {
    val (numberOfKnowledge, numberOfProblem) = readln().split(" ").map { it.toInt() }
    val duration = readln().split(" ").map { it.toInt() }
    val pre = List(numberOfProblem) {
        readln().split(" ").map { it.toInt() - 1 }.toMutableList().apply { removeFirst() }
    }

    val known = MutableList(numberOfKnowledge) { 0 }
    val solved = MutableList(numberOfProblem) { false }
    var answer = Int.MAX_VALUE
    fun select(day: Int, acc: Int) {
        if (acc >= answer) {
            return
        }

        if (day == numberOfProblem) {
            answer = acc
        } else { // select next
            for (pID in 0 until numberOfProblem) {
                if (!solved[pID]) {
                    solved[pID] = true
                    val change = pre[pID].filter { kID -> known[kID] <= day }.map { kID ->
                        val origin = known[kID]
                        known[kID] = day + duration[kID]
                        kID to origin
                    }
                    select(day + 1, acc + change.size)
                    change.forEach { (kID, origin) ->
                        known[kID] = origin
                    }
                    solved[pID] = false
                }
            }
        }
    }
    select(0, 0)
    println(answer)
}