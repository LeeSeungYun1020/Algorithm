fun main() {
    val n = readln().toInt()
    var isEvenEnemy = false
    var isOddEnemy = false
    var isEvenAttack = false
    var isOddAttack = false
    repeat(n) { x ->
        readln().split(" ").forEachIndexed { y, unit ->
            when (unit.toInt()) {
                1 -> {
                    if ((x + y) % 2 == 0) {
                        isEvenEnemy = true
                    } else {
                        isOddEnemy = true
                    }
                }

                2 -> {
                    if ((x + y) % 2 == 0) {
                        isOddAttack = true
                    } else {
                        isEvenAttack = true
                    }
                }
            }
        }
    }
    if ((isEvenEnemy && !isEvenAttack) || (isOddEnemy && !isOddAttack)) {
        println("Kiriya")
    } else {
        println("Lena")
    }
}