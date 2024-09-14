fun main() {
    val size = 8
    val medium = readln().toInt()
    val product = List(size) { readln().split(" ").map { it.toInt() - medium } }
    val row = product.map { it.sum() }
    val column = List(size) { i -> product.sumOf { it[i] } }
    val sum = row.sum() / (size * 2 - 1)
    print(buildString {
        for (i in 0 until size) {
            for (j in 0 until size) {
                val ret = (row[i] + column[j] - (sum * 2)) / (size - 1) - product[i][j]
                append(
                    when (ret) {
                        1 -> "+ "
                        -1 -> "- "
                        else -> ". "
                    }
                )
            }
            append("\n")
        }
    })
}