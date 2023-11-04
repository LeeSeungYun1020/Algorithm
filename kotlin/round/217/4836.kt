fun main() {
    val last = listOf("clap", "stomp", "clap")
    while (true) {
        val input = readlnOrNull()?.split(" ")?.toMutableList() ?: return
        val conditions = MutableList(5) { true }
        if (input[0] == "jiggle") {
            conditions[3] = false
        }
        if (input.size < 3 || (input.slice(input.lastIndex - 2..input.lastIndex) != last)) {
            conditions[1] = false
        }

        var prev = ""
        var prev2 = ""
        var containsTwirl = false
        var containsHop = false
        var containsDip = false
        var checkDip = false
        for ((index, dance) in input.withIndex()) {
            if (checkDip) {
                checkDip = false
                if (dance != "twirl") {
                    conditions[0] = false
                    input[index - 1] = input[index - 1].uppercase()
                }
            }

            when (dance) {
                "twirl" -> {
                    containsTwirl = true
                }

                "hop" -> {
                    containsHop = true
                }

                "dip" -> {
                    containsDip = true
                    if (prev != "jiggle" && prev2 != "jiggle") {
                        checkDip = true
                    }
                }
            }

            prev2 = prev
            prev = dance
        }

        if (checkDip) {
            conditions[0] = false
            input[input.lastIndex] = input.last().uppercase()
        }

        if (containsTwirl) {
            if (!containsHop) {
                conditions[2] = false
            }
        }

        if (!containsDip) {
            conditions[4] = false
        }

        println(when (conditions.count { !it }) {
            0 -> "form ok: "
            1 -> "form error ${conditions.indexOf(false) + 1}: "
            2 -> "form errors ${conditions.indexOf(false) + 1} and ${conditions.lastIndexOf(false) + 1}: "
            else -> "form errors ${
                conditions.withIndex().filter { !it.value }.map { it.index + 1 }.let {
                    "${it.slice(0 until it.lastIndex).joinToString()} and ${it.last()}"
                }
            }: "
        } + input.joinToString(
            separator = " "
        ))
    }
}