import java.util.*

fun main() {
    val (numberOfPorts, numberOfQueries) = readln().split(" ").map { it.toInt() }

    val charger = MultiPortCharger(numberOfPorts)

    buildString {
        repeat(numberOfQueries) { order ->
            val (type, port) = readln().split(" ").map { it.toInt() }
            when (type) {
                1 -> charger.plugin(port, order + 1)
                2 -> charger.plugout(port)
                else -> throw IllegalArgumentException("Unknown type: $type")
            }.let { append("$it\n") }
        }
    }.run { println(this) }
}

class MultiPortCharger(numberOfPorts: Int) {
    private val space = TreeSet<Int>()
    private val ports = mutableMapOf<Int, Int>()

    init {
        (1..numberOfPorts).forEach { space.add(it) }
    }

    fun plugin(port: Int?, order: Int): Int {
        val target = (if (ports.contains(port)) space.ceiling(port) else port) ?: return -1
        ports[target] = order
        space.remove(target)
        return target
    }

    fun plugout(port: Int?): Int {
        if (port == null) return -1
        val order = ports.remove(port)
        space.add(port)
        return order ?: -1
    }
}