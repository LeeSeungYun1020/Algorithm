fun main() {
    readln()
    println(readln().split(" ").map { it.toInt() }.windowed(2).map { (prev, now) ->
        (prev - now) * (prev - now) + (prev + now) * (prev + now)
    }.sum())
}