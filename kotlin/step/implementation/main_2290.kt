const val B = ' '
const val W = '-'
const val H = '|'

fun main() {
    val input = readln().split(" ")
    val s = input[0].toInt()
    val width = (s+3) * input[1].length - 1
    val height = 2 * s + 3
    val monitor = List(height) { MutableList(width) { ' ' } }

    //val top = 0
    val middle = s + 1
    val bottom = 2 * s + 2

    //val start = 0
    val end = s + 1

    fun top(left: Int) {
        for (i in 1 until end)
            monitor[0][left + i] = W
    }

    fun middle(left: Int) {
        for (i in 1 until end)
            monitor[middle][left + i] = W
    }

    fun bottom(left: Int) {
        for (i in 1 until end)
            monitor[bottom][left + i] = W
    }

    fun startTop(left: Int) {
        for (i in 1 until middle)
            monitor[i][left] = H
    }

    fun startBottom(left: Int) {
        for (i in middle + 1 until bottom)
            monitor[i][left] = H
    }

    fun endTop(left: Int) {
        for (i in 1 until middle)
            monitor[i][left + end] = H
    }

    fun endBottom(left: Int) {
        for (i in middle + 1 until bottom)
            monitor[i][left + end] = H
    }

    for ((idx, left) in (0 until width step s+3).withIndex()) {
        when(input[1][idx].digitToInt()) {
            1 -> {
                left.let {
                    endTop(it)
                    endBottom(it)
                }
            }
            2 -> {
                left.let {
                    top(it)
                    middle(it)
                    bottom(it)
                    startBottom(it)
                    endTop(it)
                }
            }
            3 -> {
                left.let {
                    top(it)
                    middle(it)
                    bottom(it)
                    endTop(it)
                    endBottom(it)
                }
            }
            4 -> {
                left.let {
                    middle(it)
                    startTop(it)
                    endTop(it)
                    endBottom(it)
                }
            }
            5 -> {
                left.let {
                    top(it)
                    middle(it)
                    bottom(it)
                    startTop(it)
                    endBottom(it)
                }
            }
            6 -> {
                left.let {
                    top(it)
                    middle(it)
                    bottom(it)
                    startTop(it)
                    startBottom(it)
                    endBottom(it)
                }
            }
            7 -> {
                left.let {
                    top(it)
                    endTop(it)
                    endBottom(it)
                }
            }
            8 -> {
                left.let {
                    top(it)
                    middle(it)
                    bottom(it)
                    startTop(it)
                    startBottom(it)
                    endTop(it)
                    endBottom(it)
                }
            }
            9 -> {
                left.let {
                    top(it)
                    middle(it)
                    bottom(it)
                    startTop(it)
                    endTop(it)
                    endBottom(it)
                }
            }
            else  -> {
                left.let {
                    top(it)
                    bottom(it)
                    startTop(it)
                    startBottom(it)
                    endTop(it)
                    endBottom(it)
                }
            }
        }
    }
    println(monitor.joinToString("\n") { it.joinToString("") })
}