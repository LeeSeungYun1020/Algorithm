fun main() {
    val numberOfCase = readln().toInt()
    CaseLoop@
    for (case in 1..numberOfCase) {
        val numbers = List(readln().toInt()) { readln().toInt() }
        CalcLoop@
        for (m in 1..Int.MAX_VALUE) {
            val intermediate = mutableListOf<Int>()
            for (number in numbers) {
                val target = number % m
                if (target in intermediate)
                    continue@CalcLoop
                else
                    intermediate.add(target)
            }
            if (intermediate.size == numbers.size) {
                println(m)
                continue@CaseLoop
            }
        }
    }
}