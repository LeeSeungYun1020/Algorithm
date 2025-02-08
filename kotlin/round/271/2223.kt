fun main() {
    val (time, count, numberOfMonsters) = readln().split(" ").map { it.toInt() }
    val monsters = List(numberOfMonsters) { readln().split(" ").map { it.toInt() }.let { Monster(it[0], it[1]) } }
    val target = monsters.minByOrNull { it.position / it.speed }

    if (target == null) {
        println(time * count)
    } else {
        var gold = 0
        repeat(time) {
            if (target.isSafeMove) {
                gold += count
                target.move()
            } else {
                target.back()
            }
        }
        println(gold)
    }
}

class Monster(val position: Int, val speed: Int) {
    private var distance = position
    val isSafeMove get() = (distance - speed) > 0

    fun move() {
        distance -= speed
    }

    fun back() {
        distance += speed
        if (distance > position) distance = position
    }
}