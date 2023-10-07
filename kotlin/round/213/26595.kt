fun main() {
    val money = readln().toLong()
    val (aPower, aPay, bPower, bPay) = readln().split(" ").map { it.toLong() }
    var mx = -1L
    var answer = Answer(0, 0)
    for (x in money / aPay downTo 0) {
        val y = (money - x * aPay) / bPay
        val calc = aPower * x + bPower * y
        if (mx < calc) {
            mx = calc
            answer = Answer(x, y)
        }
        //println(calc)
    }
    println(answer)
}

data class Answer(val x: Long, val y: Long) {
    override fun toString(): String {
        return "$x $y"
    }
}