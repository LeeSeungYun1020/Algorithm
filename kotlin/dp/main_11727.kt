fun main() {
    val num = readLine()!!.toInt()
    var a = 1;
    var b = 1;
    for (i in 1.until(num)){
        val tem = a;
        a = b;
        b = (tem * 2 + b) % 10007;
    }
    println(b)
}