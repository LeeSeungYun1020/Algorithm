fun main() {
    for (line in readLine()!!.split("\n")){
        when(val sum = line.split(" ").map { it.toInt() }.sum()){
            0 -> return
            else -> println(sum)
        }
    }
}