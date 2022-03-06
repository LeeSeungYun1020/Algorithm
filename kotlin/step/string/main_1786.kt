fun main() {
    val str = readln()
    val pattern = readln()
    val pi = MutableList(pattern.length) { 0 }
    val ans = mutableListOf<Int>()

    var j = 0
    for (i in 1..pattern.lastIndex) {
        while (j > 0 && pattern[i] != pattern[j])
            j = pi[j - 1]
        if (pattern[i] == pattern[j]) {
            j += 1
            pi[i] = j
        }
    }

    j = 0
    for (i in 0..str.lastIndex) {
        while (j > 0 && str[i] != pattern[j])
            j = pi[j - 1]
        if (str[i] == pattern[j]) {
            if (j == pattern.lastIndex) {
                ans.add(i - pattern.lastIndex + 1)
                j = pi[j]
            } else {
                j += 1
            }
        }
    }

    println(ans.size)
    println(ans.joinToString(" "))
}