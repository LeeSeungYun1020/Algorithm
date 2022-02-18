import Type.*

enum class Type {
    GARO, SERO, DAE
}

// 집의 크기
val N = readLine()!!.toInt()

// 집의 상태 - 빈칸: 0, 벽: 1
val status = List(N) { readLine()!!.split(" ").map { it == "0" } }
val visited = Array(N) { Array(N) { false } }
var answer = 0

fun addGaro(x: Int, y: Int) {
    if (visited.getOrNull(x)?.getOrNull(y + 1) == false && status.getOrNull(x)?.getOrNull(y + 1) == true) {
        visited[x][y + 1] = true
        bfs(GARO, x, y + 1)
        visited[x][y + 1] = false
    }
}

fun addSero(x: Int, y: Int) {
    if (visited.getOrNull(x + 1)?.getOrNull(y) == false && status.getOrNull(x + 1)?.getOrNull(y) == true) {
        visited[x + 1][y] = true
        bfs(SERO, x + 1, y)
        visited[x + 1][y] = false
    }
}

fun addDae(x: Int, y: Int) {
    if (visited.getOrNull(x + 1)?.getOrNull(y) == false && visited.getOrNull(x + 1)
            ?.getOrNull(y + 1) == false && visited.getOrNull(x)?.getOrNull(y + 1) == false
        && status.getOrNull(x + 1)?.getOrNull(y) == true && status.getOrNull(x + 1)
            ?.getOrNull(y + 1) == true && status.getOrNull(x)?.getOrNull(y + 1) == true
    ) {
        visited[x + 1][y] = true
        visited[x + 1][y + 1] = true
        visited[x][y + 1] = true
        bfs(DAE, x + 1, y + 1)
        visited[x + 1][y] = false
        visited[x + 1][y + 1] = false
        visited[x][y + 1] = false
    }
}

fun bfs(type: Type, x: Int, y: Int) {
    if (x == N - 1 && y == N - 1) {
        answer += 1
        return
    }

    when (type) {
        GARO -> {
            addGaro(x, y)
        }
        SERO -> {
            addSero(x, y)
        }
        DAE -> {
            addGaro(x, y)
            addSero(x, y)
        }
    }
    addDae(x, y)
}

fun main() {
    visited[0][0] = true
    visited[0][1] = true

    bfs(GARO, 0, 1)
    println(answer)
}