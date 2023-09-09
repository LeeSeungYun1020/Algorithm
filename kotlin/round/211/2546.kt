fun main() {
    val numberOfCase = readln().toInt()
    repeat(numberOfCase) {
        // 빈 줄 구분
        readln()
        val (numberOfC, numberOfEconomy) = readln().split(" ").map { it.toInt() }
        //val iq = readln().split(" ").map { it.toInt() }
        //val c = iq.slice(0 until numberOfC)
        //val economy = iq.slice(numberOfC..iq.lastIndex)
        // 문제 설명 대로 하면 틀림
        val c = readln().split(" ").map { it.toInt() }
        val economy = readln().split(" ").map { it.toInt() }

        val cAverage = c.average()
        val eAverage = economy.average()
        var num = 0
        for (person in c) {
            if (cAverage > person && eAverage < person) {
                num++
            }
        }
        println(num)
    }
}