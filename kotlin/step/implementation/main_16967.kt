fun main() {
    val (height, weight, x, y) = readln().split(" ").map { it.toInt() }
    val result = List(height + x) { readln().split(" ").map { it.toInt() } }
    val origin = List(height) { MutableList(weight) { 0 } }
    for (i in 0 until height) {
        for (j in 0 until weight) {
            if (i < x || j < y)
                origin[i][j] = result[i][j]
        }
    }

    for (i in x until height + x) {
        for (j in y until weight + y) {
            if (i >= height || j >= weight)
                origin[i - x][j - y] = result[i][j]
        }
    }

    for (i in x until height) {
        for (j in y until weight) {
            origin[i][j] = result[i][j] - origin[i-x][j-y]
        }
    }

    println(origin.joinToString("\n"){ it.joinToString(" ") })
}