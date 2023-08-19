import kotlin.math.absoluteValue

fun main() {
    while (true) {
        val music = readln().split(" ").toMutableList()
        if (music.first() == "***")
            break

        val move = readln().toInt()
        println(music.joinToString(separator = " ") { level ->
            var intermediate = level
            repeat(move.absoluteValue) {
                if (move > 0)
                    intermediate++
                else
                    intermediate--
            }
            intermediate
        })
    }
}

operator fun String.inc(): String {
    return when (this) {
        "A" -> "A#"
        "A#", "Bb" -> "B"
        "B", "Cb" -> "C"
        "C", "B#" -> "C#"
        "C#", "Db" -> "D"
        "D" -> "D#"
        "D#", "Eb" -> "E"
        "E", "Fb" -> "F"
        "F", "E#" -> "F#"
        "F#", "Gb" -> "G"
        "G" -> "G#"
        "G#", "Ab" -> "A"
        else -> ""
    }
}

operator fun String.dec(): String {
    return when (this) {
        "A" -> "G#"
        "A#", "Bb" -> "A"
        "B", "Cb" -> "A#"
        "C", "B#" -> "B"
        "C#", "Db" -> "C"
        "D" -> "C#"
        "D#", "Eb" -> "D"
        "E", "Fb" -> "D#"
        "F", "E#" -> "E"
        "F#", "Gb" -> "F"
        "G" -> "F#"
        "G#", "Ab" -> "G"
        else -> ""
    }
}