fun main() {
    val (hp1, attack1, hp2, attack2) = readln().split(" ").map { it.toLong() }
    val (pos, heal) = readln().split(" ").map { it.toLong() }

    val me = Player(hp1, attack1)
    val enemy = Player(hp2, attack2)

    if (me.attack == 1L || enemy.hp % me.attack in 1..pos) enemy.hp += heal

    val meCount = enemy.hp / me.attack + if (enemy.hp % me.attack == 0L) 0 else 1
    val enemyCount = me.hp / enemy.attack + if (me.hp % enemy.attack == 0L) 0 else 1
    if (meCount > enemyCount) println("gg")
    else println("Victory!")
}

class Player(var hp: Long, val attack: Long)