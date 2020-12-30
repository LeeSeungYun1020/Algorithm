fun main() {
    for (line in readLine()!!.split("\n")){
        println(line.split(" ").map { it.toInt() }.sum())
    }
}