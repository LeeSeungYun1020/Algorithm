fun main() {
    readln()

    var d = 0
    var k = 0L
    var s = 0L
    var h = 0L

    readln().forEach { c ->
        when (c) {
            'D' -> {
                d++
            }

            'K' -> {
                k += d
            }

            'S' -> {
                s += k
            }

            'H' -> {
                h += s
            }
        }
    }
    println(h)
}