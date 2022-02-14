fun main() {
    print(readLine()!!.split('-').map {
        it.split('+').sumBy { it.toInt() }
    }.reduce { acc, i -> acc - i })
}