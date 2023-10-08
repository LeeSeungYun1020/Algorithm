fun main() {
    val (numberOfPeople, numberOfRing) = readln().split(" ").map { it.toInt() }
    val bell = List(numberOfPeople) { readln().split(" ").map { it == "1" } }
    val status = MutableList(numberOfPeople) { true }

    (0 until numberOfRing).sortedByDescending { ring -> bell.count { it[ring] } }.forEach { ringIndex ->
        bell.forEachIndexed { peopleIndex, people ->
            if (people[ringIndex]) { // 들었다면
                if (!status[peopleIndex]) { // 앞에꺼 안들었다면 거짓
                    println("NO")
                    return
                }
            } else { // 못들었다면
                status[peopleIndex] = false
            }
        }
    }
    println("YES")
}