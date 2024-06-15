fun main() {
    val n = readln().toInt()
    val windows = readln().split(" ").map { NumberFile(it.toInt()) }

    for (target in 1..n) {
        var isMet = false
        windows.forEach {
            when {
                it.isFixed -> return@forEach
                it.order == target -> {
                    isMet = true
                    it.isFixed = true
                    it.nameBuilder.append(2)
                }
                !isMet -> {
                    it.nameBuilder.append(1)
                }
                isMet -> {
                    it.nameBuilder.append(2)
                }

            }
        }
    }
    println(windows.joinToString(separator = " ") { it.nameBuilder.toString() })
}

class NumberFile(val order: Int, var nameBuilder: StringBuilder = StringBuilder(), var isFixed: Boolean = false)
