fun main() {
    val (numberOfStudents, _, _, numberOfRange) = readln().split(" ").map { it.toInt() }
    val students = MutableList(numberOfStudents + 3) { Status.TARDY }
    readln().split(" ").forEach {
        students[it.toInt()] = Status.ABSENT
    }
    readln().split(" ").map { it.toInt() }
        .filter { students[it] != Status.ABSENT }
        .forEach { sender ->
            (sender..students.lastIndex step sender)
                .filter { students[it] != Status.ABSENT }
                .forEach { students[it] = Status.PRESENT }
        }
    val absentCounter = students.runningFoldIndexed(0) { index, acc, status ->
        if (index < 3) 0 else if (status != Status.PRESENT) acc + 1 else acc
    }
    (1..numberOfRange).map {
        val (start, end) = readln().split(" ").map { it.toInt() }
        absentCounter[end + 1] - absentCounter[start]
    }.joinToString(separator = "\n").run(::println)
}

enum class Status {
    PRESENT, ABSENT, TARDY
}