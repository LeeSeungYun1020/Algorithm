fun main() {
    val (n, m, r) = readln().split(" ").map { it.toInt() }
    val number = MutableList(n) { readln().split(" ").map { it.toInt() }.toMutableList() }
    val rotate = MutableList(m) { MutableList(n) { 0 } }
    val operation = readln().split(" ").map { it.toInt() }

    var isRotate = false
    for (oper in operation) {
        val target = if (isRotate) rotate else number
        when(oper) {
            1 -> {
                target.reverse()
            }
            2 -> {
                target.map { it.reverse() }
            }
            3 -> {
                val newTarget = if (isRotate) number else rotate
                val width = if (isRotate) m else n
                val height = if (isRotate) n else m
                for (i in 0 until height)
                    for (j in 0 until width)
                        newTarget[i][j] = target[width - 1 - j][i]
                isRotate = !isRotate
            }
            4 -> {
                val newTarget = if (isRotate) number else rotate
                val width = if (isRotate) m else n
                val height = if (isRotate) n else m
                for (i in 0 until height)
                    for (j in 0 until width)
                        newTarget[i][j] = target[j][height - 1 - i]
                isRotate = !isRotate
            }
            5 -> {
                val width = if (isRotate) n else m
                val height = if (isRotate) m else n
                val halfWidth = width / 2
                val halfHeight = height / 2
                // 1번 항목
                val tem = List(halfHeight) { h -> List(halfWidth) { w -> target[h][w] } }
                // 4 -> 1
                for (i in 0 until halfHeight)
                    for (j in 0 until halfWidth)
                        target[i][j] = target[i + halfHeight][j]
                // 3 -> 4
                for (i in halfHeight until height) {
                    for (j in 0 until halfWidth) {
                        target[i][j] = target[i][j + halfWidth]
                    }
                }
                // 2 -> 3
                for (i in halfHeight until height) {
                    for (j in halfWidth until width) {
                        target[i][j] = target[i-halfHeight][j]
                    }
                }
                // 1(tem) -> 2
                for (i in 0 until halfHeight) {
                    for (j in halfWidth until width) {
                        target[i][j] = tem[i][j - halfWidth]
                    }
                }
            }
            6 -> {
                val width = if (isRotate) n else m
                val height = if (isRotate) m else n
                val halfWidth = width / 2
                val halfHeight = height / 2
                // 1번 항목
                val tem = List(halfHeight) { h -> List(halfWidth) { w -> target[h][w] } }
                // 2 -> 1
                for (i in 0 until halfHeight)
                    for (j in 0 until halfWidth)
                        target[i][j] = target[i][j + halfWidth]

                // 3 -> 2
                for (i in 0 until halfHeight) {
                    for (j in halfWidth until width) {
                        target[i][j] = target[i + halfHeight][j]
                    }
                }

                // 4 -> 3
                for (i in halfHeight until height) {
                    for (j in halfWidth until width) {
                        target[i][j] = target[i][j - halfWidth]
                    }
                }

                // 1(tem) -> 4
                for (i in halfHeight until height) {
                    for (j in 0 until halfWidth) {
                        target[i][j] = tem[i - halfHeight][j]
                    }
                }
            }
        }
    }
    println((if (isRotate) rotate else number).map { it.joinToString(separator = " ") }.joinToString("\n"))
}