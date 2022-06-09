fun main() {
    val str = readln()
    val strSubSet = mutableSetOf<String>()
    for (i in 0..str.lastIndex) {
        for (j in i + 1..str.length) {
            strSubSet.add(str.substring(i, j))
        }
    }
    println(strSubSet.count())
}