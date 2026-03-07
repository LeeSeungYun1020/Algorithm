fun main() {
    val command = convertCommand(readln())

    var state = 0
    for (direction in converInput(readln())) {
        if (state == command.size) state = 0
        else if (command[state] == direction) state += 1
        else state = 0
    }
    if (state == command.size) println("Yes")
    else println("No")
}

fun convertCommand(command: String): List<Direction> {
    val result = mutableListOf<Direction>()
    var i = 0
    while (i < command.length) {
        if (i + 2 < command.length) {
            val key = when (command.substring(i..i + 2)) {
                "LU!" -> Direction.RD
                "LD!" -> Direction.RU
                "RU!" -> Direction.LD
                "RD!" -> Direction.LU
                else -> null
            }
            if (key != null) {
                result.add(key)
                i += 3
                continue
            }
        }
        if (i + 1 < command.length) {
            val key = when (command.substring(i..i + 1)) {
                "LU" -> Direction.LU
                "LD" -> Direction.LD
                "RU" -> Direction.RU
                "RD" -> Direction.RD
                "W!" -> Direction.D
                "A!" -> Direction.R
                "S!" -> Direction.U
                "D!" -> Direction.L
                else -> null
            }
            if (key != null) {
                result.add(key)
                i += 2
                continue
            }
        }
        result.add(
            when (command[i]) {
                'W' -> Direction.U
                'A' -> Direction.L
                'S' -> Direction.D
                'D' -> Direction.R
                else -> Direction.R
            }
        )
        i += 1
    }
    return result
}

fun converInput(input: String): List<Direction> {
    return input.map {
        when (it) {
            'W', '8' -> Direction.U
            'S', '2' -> Direction.D
            'A', '4' -> Direction.L
            'D', '6' -> Direction.R
            '7' -> Direction.LU
            '1' -> Direction.LD
            '9' -> Direction.RU
            '3' -> Direction.RD
            else -> Direction.RD
        }
    }
}

enum class Direction {
    U, L, D, R, LU, LD, RU, RD
}