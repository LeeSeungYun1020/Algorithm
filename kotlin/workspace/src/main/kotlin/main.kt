fun main() {
    readLine()
    val list = readLine()!!.split(" ").map { it.toInt() }
    val sortedList = list.sorted()

    var idx = 0
    val map = mutableMapOf<Int, Int>()
    for (value in sortedList){
        if (map[value] == null) {
            map[value] = idx++
        }
    }

    val sb = StringBuilder()
    for (value in list) {
        sb.append(map[value]).append(' ')
    }
    print(sb)
}