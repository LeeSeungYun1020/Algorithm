fun main() {
    val power2 = listOf(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144)
    repeat(readln().toInt()) {
        var target = readln().toInt() + 1 // 첫번째 실행 선보정
        val step = mutableListOf<Int>()
        while (target > 0) {
            for (i in (step.lastOrNull() ?: power2.lastIndex) downTo 0) {
                if (power2[i] <= target) {
                    step.add(i)
                    target -= power2[i]
                    break
                }
            }
        }

        var mx = step.first()
        val answer = MutableList(mx) { it + 1 }
        for (i in 1..step.lastIndex) {
            answer.add(step[i], ++mx)
        }
        println(answer.size)
        println(answer.joinToString(separator = " "))
    }
}