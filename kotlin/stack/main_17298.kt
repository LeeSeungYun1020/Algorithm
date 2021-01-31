fun main() {
    readLine()
    val num = readLine()!!.split(' ').map { it.toInt() }
    num.forEachIndexed { index, n ->
        if (index == num.lastIndex){
            println(-1)
            return
        }
        for (i in index + 1 .. num.lastIndex){
            if (n < num[i]){
                print("${num[i]} ")
                break
            }
            if (i == num.lastIndex)
                print("-1 ")
        }
    }
}