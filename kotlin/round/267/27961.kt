fun main() {
    val target = readln().toLong()
    print(
        if (target == 0L) 0
        else generateSequence(1L) { it * 2 }.takeWhile { target > it }.count() + 1
    )
}