fun main() {
    val size = readln().toInt()
    val chicken = readln().count { it == 'C' }
    val split = size - chicken + 1
    println(chicken / split + if (chicken % split == 0) 0 else 1)
}