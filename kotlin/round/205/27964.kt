fun main() {
    readln()
    println(
        if (readln().split(" ").toSet().count { it.endsWith("Cheese") } >= 4)
            "yummy"
        else
            "sad"
    )
}