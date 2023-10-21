fun main() {
    readln()
    val attack = readln().split(" ").map { it.toLong() }
    var target = attack.first()
    attack.slice(1..attack.lastIndex).sorted().forEach {
        if (target > it) {
            target += it
        } else {
            println("No")
            return
        }
    }
    println("Yes")
}