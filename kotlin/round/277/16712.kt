fun main() {
    val (_, numberOfParticipants) = readln().split(" ").map { it.toInt() }
    val scores = readln().split(" ").map { it.toInt() }
    val drops = readln().split(" ").map { it.toInt() - 1 }

    val current = scores.slice(0 until numberOfParticipants).sorted().toMutableList()
    var last = current.size
    drops.forEach {
        current.removeAt(it)
        if (scores.size > last) current.add(scores[last++])
        current.sort()
    }
    println(current.joinToString(" "))
}