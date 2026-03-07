import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    // 시간 초과 때문에 buffer 입력, array 사용
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val canvas = Array(n) {
        br.readLine().split(" ").map { it.toInt() }.chunked(3) { (r, g, b) -> (r shl 16) + (g shl 8) + b }.toIntArray()
    }
    val visited = Array(n) { BooleanArray(m) { false } }
    val deque = ArrayDeque<ColorPoint>()
    val directions = arrayOf(
        -1 to -1, -1 to 0, -1 to 1,
        0 to -1, 0 to 1,
        1 to -1, 1 to 0, 1 to 1
    )
    var count = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!visited[i][j]) {
                count++
                visited[i][j] = true
                deque.add(ColorPoint(i, j, canvas[i][j]))
                while (deque.isNotEmpty()) {
                    val (x, y, color) = deque.removeFirst()
                    for ((px, py) in directions) {
                        val nx = x + px
                        val ny = y + py
                        if (nx in 0 until n && ny in 0 until m && !visited[nx][ny] && canvas[nx][ny] == color) {
                            visited[nx][ny] = true
                            deque.add(ColorPoint(nx, ny, color))
                        }
                    }
                }
            }
        }
    }
    println(count)
}

data class ColorPoint(val x: Int, val y: Int, val color: Int)