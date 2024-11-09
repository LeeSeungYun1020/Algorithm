fun main() {
    readln().split(" ")
        .map { it.toInt() }
        .let { (left, right) ->
            (1..(left * right))
                .map { (it % right == 0) to (it % left == 0) }
                .filter { it.first || it.second }
                .map { (isLeft, isRight) ->
                    when {
                        isLeft && isRight -> 3
                        isLeft -> 1
                        isRight -> 2
                        else -> 0
                    }
                }
                .joinToString(separator = "")
                .run(::println)
        }
}