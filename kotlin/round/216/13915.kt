fun main() {
    while (true) {
        val numberOfCase = readlnOrNull()?.toInt() ?: break
        val cases = mutableSetOf<Set<Char>>()
        repeat(numberOfCase) {
            cases.add(readln().toSet())
        }
        println(cases.count())
    }
}