import kotlin.math.min

fun main() {
    val (numberOfSkill, hp) = readln().split(" ").map { it.toInt() }
    val skills = List(numberOfSkill) {
        readln().toSkill()
    }
    var minTime = Int.MAX_VALUE

    val skillDelay = MutableList(numberOfSkill) { 0 }
    fun dfs(time: Int, remainedHp: Int) {
        if (time > minTime) {
            return
        }
        if (remainedHp <= 0) {
            minTime = time
        }

        for ((i, delay) in skillDelay.withIndex()) {
            if (delay <= time) {
                skillDelay[i] = time + skills[i].delay
                dfs(time + 1, remainedHp - skills[i].damage)
                skillDelay[i] = delay
            }
        }
        dfs(time + 1, remainedHp)
    }

    dfs(0, hp)
    println(minTime)
}

data class Skill(val delay: Int, val damage: Int)

fun String.toSkill() = this.split(" ").map { it.toInt() }.let { Skill(it[0], it[1]) }