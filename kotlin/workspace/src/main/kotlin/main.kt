fun main() {
    val month = listOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30)
    val date = readLine()!!.split(' ').map { it.toInt() }
    var sum = date[1]
    for (i in 0.until(date[0]))
        sum += month[i]
    println(when(sum % 7){
        0 -> "SUN"
        1 -> "MON"
        2 -> "TUE"
        3 -> "WED"
        4 -> "THU"
        5 -> "FRI"
        else -> "SAT"
    })
}