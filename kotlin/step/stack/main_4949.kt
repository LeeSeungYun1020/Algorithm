fun main() {
    while (true) {
        val line = readLine()!!
        if (line == ".")
            break

        val open = mutableListOf<Char>()
        var check = false
        for (c in line) {
            when (c) {
                '(', '[' -> open.add(c)
                ')' -> if (open.lastOrNull() == '(') open.removeLast() else {
                    check = true
                    break
                }
                ']' -> if (open.lastOrNull() == '[') open.removeLast() else {
                    check = true
                    break
                }
            }
        }
        if (open.size == 0 && !check) println("yes")
        else println("no")
    }
}