fun main() {
    val numbers = List(readln().toInt()) { readln().toInt() }
    val checker = numbers.associateWith { -1 }.toMutableMap()
    val dp = MutableList(numbers.max() * 2 + 1) { -1 }
    val deque = ArrayDeque<State>()
    deque.add(State(0, 1))
    while (deque.isNotEmpty()) {
        val state = deque.removeFirst()
        if (dp[state.number] < 0) {
            dp[state.number] = state.level
            if (checker.containsKey(state.number)) {
                checker[state.number] = state.level
                if (checker.values.all { it != -1 }) {
                    break
                }
            }
            if (state.number * 2 <= dp.lastIndex) {
                deque.add(State(state.level + 1, state.number * 2))
            }
            if (state.number - 1 != 0) {
                deque.add(State(state.level + 1, state.number - 1))
            }
        }
    }
    numbers.map { checker[it] }.joinToString(separator = "\n").run(::println)
}

class State(val level: Int, val number: Int)