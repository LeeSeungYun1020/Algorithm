fun main() {
    val (numberOfMemo, numberOfBlog) = readln().split(" ").map { it.toInt() }
    val memo = List(numberOfMemo) { readln() }.toMutableSet()
    repeat(numberOfBlog) {
        memo.removeAll(readln().split(",").toSet())
        println(memo.count())
    }
}