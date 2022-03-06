fun main() {
    val str = readln()
    val pattern = readln()
    val schedule = ArrayDeque<Int>()
    val ans = mutableListOf<Int>()
    for (i in 0..str.lastIndex) {
        if (str[i] == pattern[0])
            schedule.addFirst(0)
        for (j in 0..schedule.lastIndex) {
            if (pattern[schedule[j]] == str[i])
                schedule[j] += 1
            else
                schedule[j] = -1
        }
        schedule.removeIf { it == -1 }
        if (schedule.lastOrNull() == pattern.length) {
            schedule.removeLast()
            ans.add(i - pattern.lastIndex + 1)
        }
    }
    println(ans.size)
    println(ans.joinToString(" "))
}