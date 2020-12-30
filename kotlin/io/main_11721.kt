fun main() {
    readLine()!!.mapIndexed { i: Int, c: Char -> if ((i+1) % 10 == 0) println(c) else print(c) }
}