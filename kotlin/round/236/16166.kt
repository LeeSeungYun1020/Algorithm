fun main() {
    val numberOfLines = readln().toInt()

    // station -> line
    val stationMap = mutableMapOf<Int, MutableSet<Int>>()
    // line -> transfer station
    val lineMap = mutableMapOf<Int, MutableSet<Int>>()

    repeat(numberOfLines) { line ->
        var remove = false
        readln().split(" ").map { it.toInt() }.forEach { station ->
            if (!remove) {
                remove = true
                return@forEach
            }
            stationMap[station]?.run {
                // 환승역인 경우
                if (add(line)) {
                    forEach { line ->
                        lineMap.getOrPut(line) { mutableSetOf() }.add(station)
                    }
                }

            } ?: run {
                stationMap[station] = mutableSetOf(line)
            }
        }
    }

    val deque = ArrayDeque<Status>()
    val visitedLine = MutableList(numberOfLines) { false }
    // 출발
    stationMap[0]?.run {
        map {
            visitedLine[it] = true
            Status(it, 0)
        }.let { deque.addAll(it) }
    } ?: run {
        println(-1)
        return
    }
    // 도착
    val arrivalLine = stationMap[readln().toInt()] ?: run {
        println(-1)
        return
    }

    while (deque.isNotEmpty()) {
        val (currentLine, transferCount) = deque.removeFirst()
        if (currentLine in arrivalLine) {
            println(transferCount)
            return
        }
        lineMap[currentLine]?.forEach { transferStation ->
            stationMap[transferStation]?.forEach { transferLine ->
                if (!visitedLine[transferLine]) {
                    visitedLine[transferLine] = true
                    deque.addLast(Status(transferLine, transferCount + 1))
                }
            }
        }
    }

    println(-1)
}

data class Status(val currentLine: Int, val transferCount: Int)