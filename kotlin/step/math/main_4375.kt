fun main() {
    var num = readLine()?.toIntOrNull()?:return
    while (true) {
        if (num == 1) {
            println(1)
            num = readLine()?.toIntOrNull()?:return
            continue
        }
        var one = 11
        var count = 2
        while (one % num != 0) {
            one = (one * 10 + 1) % num
            count += 1
        }
        println(count)
        num = readLine()?.toIntOrNull()?:return
    }
}