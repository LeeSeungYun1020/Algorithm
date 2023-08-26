import java.util.ArrayDeque

fun main() {
    val (numberOfContainer, _) = readln().split(" ").map { it.toInt() }
    val rail = ArrayDeque<Container>()
    repeat(numberOfContainer) {
        rail.add(readln().split(" ").map { it.toInt() }.toContainer())
    }

    val ship = ArrayDeque<Container>()
    var cost = 0
    while (rail.isNotEmpty()) {
        val target = rail.maxOf { it.priority }
        val container = rail.removeFirst()
        if (container.priority == target) {
            for (compare in ship) {
                if (compare.priority == target && compare.weight < container.weight) {
                    cost += compare.weight * 2
                }
            }
            ship.addFirst(container)
        } else {
            rail.addLast(container)
        }
        cost += container.weight
    }
    println(cost)
}

data class Container(val priority: Int, val weight: Int)

fun List<Int>.toContainer(): Container = Container(this[0], this[1])