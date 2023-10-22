fun main() {
    val numberOfPeople = readln().toInt()
    val friend = List(numberOfPeople) { mutableSetOf<Int>() }
    val enemy = List(numberOfPeople) { mutableSetOf<Int>() }

    repeat(/* numberOfRelation = */ readln().toInt()) {
        val (relation, p1, p2) = readln().splitRelation()
        when (relation) {
            "E" -> {
                enemy[p1].add(p2)
                enemy[p2].add(p1)
            }

            "F" -> {
                friend[p1].add(p2)
                friend[p2].add(p1)
            }
        }
    }

    val find = MutableList(numberOfPeople) { false }
    val deque = ArrayDeque<State>()
    var team = 0
    for (i in 0 until numberOfPeople) {
        if (!find[i]) {
            find[i] = true
            team++

            val visited = MutableList(numberOfPeople) { false }
            friend[i].forEach {
                visited[it] = true
                find[it] = true
                deque.add(State(it, true))
            }
            enemy[i].forEach {
                visited[it] = true
                deque.add(State(it, false))
            }
            while (deque.isNotEmpty()) {
                val state = deque.removeFirst()
                if (state.isFriend) {
                    // 친구의 친구는 친구
                    friend[state.target].forEach {
                        if (!visited[it]) {
                            visited[it] = true
                            find[it] = true
                            deque.add(State(it, true))
                        }
                    }
                    // 친구의 적은 적
                    enemy[state.target].forEach {
                        if (!visited[it]) {
                            visited[it] = true
                            deque.add(State(it, false))
                        }
                    }
                } else {
                    // 적의 적은 친구
                    enemy[state.target].forEach {
                        if (!visited[it]) {
                            visited[it] = true
                            find[it] = true
                            deque.add(State(it, true))
                        }
                    }
                    // 적의 친구 탐색 불필요
                }
            }
        }
    }
    println(team)
}

fun String.splitRelation(): Triple<String, Int, Int> {
    val words = this.split(" ")
    return Triple(words[0], words[1].toInt() - 1, words[2].toInt() - 1)
}

data class State(val target: Int, val isFriend: Boolean)