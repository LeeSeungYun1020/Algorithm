fun main() {
    readLine()
    val list = readLine()!!.split(' ').map { it.toInt() }.sorted()
    readLine()
    readLine()!!.split(' ').map { it.toInt() }.forEach { check ->
        println(if (list.binarySearch(check) < 0) 0 else 1)
    }
}