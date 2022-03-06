fun main() {
    val n = readln().toInt()
    // 1 -> 1 + 2 = 3
    // 2 -> 1 + 4 + 2 = 7
    // 3 -> 1 + 6 + 8 + 2 = 17
    // 4 -> 41
    val animal = MutableList(n+1) { 0 }
    animal[0] = 1
    animal[1] = 3
    for (i in 2..n) {
        animal[i] = (animal[i-1] * 2 + animal[i-2]) % 9901
    }
    println(animal[n])
}