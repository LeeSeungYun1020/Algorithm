fun main() {
    val (l, c) = readLine()!!.split(" ").map { it.toInt() }
    val letter = readLine()!!.split(" ").map { it[0] }.sorted()
    val visited = MutableList(c) { false }
    val password = MutableList(l) { 0 }
    var consonant = 0
    var vowel = 0
    fun dfs(level: Int) {
        if (level == l) {
            if (consonant >= 2 && vowel >= 1) {
                for (p in password)
                    print(letter[p])
                println()
            }
            return
        }
        val start = password.getOrElse(level - 1) { 0 }
        for (i in start until c) {
            if (!visited[i]) {
                val lt = letter[i]
                val isVowel = when(lt) {
                    'a', 'e', 'i', 'o', 'u' -> true
                    else -> false
                }
                password[level] = i
                visited[i] = true
                if (isVowel) vowel++ else consonant++
                dfs(level + 1)
                visited[i] = false
                if (isVowel) vowel-- else consonant--
            }
        }
    }
    dfs(0)
}