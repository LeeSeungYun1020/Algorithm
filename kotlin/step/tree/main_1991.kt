class Node(val left: Char, val right: Char)

fun main() {
    val n = readln().toInt()
    val nodeMap = buildMap<Char, Node> {
        for (i in 0 until n) {
            val (key, left, right) = readln().split(" ").map { it[0] }
            put(key, Node(left, right))
        }
    }

    fun pre(root: Char) {
        if (root != '.') {
            print(root)
            nodeMap[root]?.left?.let { pre(it) }
            nodeMap[root]?.right?.let { pre(it) }
        }
    }

    fun inOrder(root: Char) {
        if (root != '.') {
            nodeMap[root]?.left?.let { inOrder(it) }
            print(root)
            nodeMap[root]?.right?.let { inOrder(it) }
        }
    }

    fun post(root: Char) {
        if (root != '.') {
            nodeMap[root]?.left?.let { post(it) }
            nodeMap[root]?.right?.let { post(it) }
            print(root)
        }
    }

    pre('A')
    println()
    inOrder('A')
    println()
    post('A')
}

