fun main() {
    val num = readLine()!!.toInt()
    var a = 0;
    var b = 1;
    for (i in 0.until(num)){
        val tem = a;
        a = b;
        b = (tem + b) % 10007;
    }
    println(b)
}