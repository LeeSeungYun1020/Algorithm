fun main() {
    val n = readLine()!!.toInt()
    val set = List(n) { readLine()!!.toInt() }.sorted()

    for (target in set.reversed()) {
        for (i in set.lastIndex downTo 0) {
            val a = set[i]
            if (a >= target)
                continue
            for (j in i downTo 0) {
                val b = set[j]
                if (a + b >= target)
                    continue
                for (k in j downTo 0) {
                    val c = set[k]
                    val sum = a + b + c
                    if (sum == target){
                        println(sum)
                        return
                    }
                }
            }
        }
    }
}