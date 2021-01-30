fun main() {
    val count = readLine()!!.toInt()
    for (i in 1..count){
        val num = readLine()!!.toInt()
        val clothes = mutableListOf<String>()
        for (j in 1..num){
            clothes.add(readLine()!!.split(' ')[1])
        }

        var ans = 1
        clothes.groupingBy { it }.eachCount().values.forEach {
            ans *= (it + 1)
        }
        println(ans - 1)
    }
}