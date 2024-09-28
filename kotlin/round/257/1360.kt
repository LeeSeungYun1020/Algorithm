fun main() {
    print(
        List(readln().toInt()) { readln().toCommand() }.reversed()
            .fold(Pair(StringBuilder(), Int.MAX_VALUE)) { acc, command ->
                if (acc.second > command.time) {
                    when (command) {
                        is Command.Type -> {
                            Pair(acc.first.append(command.input), acc.second)
                        }
                        is Command.Undo -> {
                            Pair(acc.first, command.time - command.duration)
                        }
                    }
                } else {
                    acc
                }
            }.first.reverse()
    )
}

sealed class Command(val time: Int) {
    class Type(val input: Char, time: Int) : Command(time)
    class Undo(val duration: Int, time: Int) : Command(time)
}

fun String.toCommand(): Command {
    val (name, param, time) = split(" ")
    return when (name) {
        "type" -> Command.Type(param.first(), time.toInt())
        else -> Command.Undo(param.toInt(), time.toInt())
    }
}