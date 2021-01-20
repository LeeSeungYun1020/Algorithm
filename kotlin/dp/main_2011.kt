fun main() {
    val word = readLine()
    if (word.isNullOrEmpty() || word.first() == '0'){
        println(0)
        return
    }
    val len = word.length
    val dp = mutableListOf(1, 2)

    if (len > 1){
        val tem = word.substring(0..1).toInt()

        if (tem % 10 == 0 && tem > 26) {
            println(0)
            return
        }
        if (tem == 10 || tem == 20 || tem > 26)
            dp[1] = 1
    }
    for (i in 2.until(len)){
        val ten = word.substring((i - 1)..i).toInt()
        val second = ten % 10
        if (ten == 0){
            println(0)
            return
        }
        dp.add(i, 0)
        if (second != 0 && 10 < ten && ten < 100)
            dp[i] = dp[i - 1]
        val tem = word.substring((i - 2) until i).toInt()
        if ((tem == 10 || tem == 20) && second != 0)
            dp[i] = dp[i - 1]
        if (ten in 10..26)
            dp[i] = (dp[i] + dp[i - 2]) % 1000000
    }
    println(dp[len - 1])
}