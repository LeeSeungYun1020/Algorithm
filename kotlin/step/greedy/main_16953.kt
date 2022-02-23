fun main() {
    var (A, B) = readLine()!!.split(" ").map { it.toInt() }
    var count = 0
    while (A <= B){
        count += 1
        if (A == B){
            println(count)
            return
        }
        else if (B % 10 == 1)
            B = (B - 1) / 10
        else if (B % 2 == 0)
            B /= 2
        else
            break
    }

    println(-1)
}