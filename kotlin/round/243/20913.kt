fun main() {
    readln()
    println(buildString {
        readln().split(" ").forEachIndexed { index, intString ->
            append(index + 100)
            append("0".repeat(intString.toInt() - 1))
            append(" ")
        }
    })
}