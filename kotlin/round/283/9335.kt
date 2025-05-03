fun main() {
    val answer = mutableListOf<Int>()
    repeat(readln().toInt()) {
        val numberOfFriends = readln().toInt()
        val friends = MutableList(numberOfFriends + 1) { 1 shl it }
        repeat(numberOfFriends) {
            val a = it + 1
            readln().split(" ").map { it.toInt() }.drop(1).forEach { b ->
                friends[a] = friends[a] or (1 shl b)
                friends[b] = friends[b] or (1 shl a)
            }
        }

        val target = (1 shl (numberOfFriends + 1)) - 2
        findValidSubset(numberOfFriends) {
            if (it.fold(0) { acc, i -> acc or friends[i] } == target) {
                answer.add(it.size)
                true
            } else false
        }
    }
    println(answer.joinToString(separator = "\n"))
}

fun findValidSubset(size: Int, action: (List<Int>) -> Boolean) {
    val current = mutableListOf<Int>()
    var found = false

    fun backtrack(start: Int, limit: Int) {
        if (found) return
        if (current.size == limit) {
            found = action(current)
            return
        }
        for (i in start..size) {
            current.add(i)
            backtrack(i + 1, limit)
            current.removeLast()
        }
    }

    for (length in 1..size) {
        if (found) return
        backtrack(1, length)
    }
}
