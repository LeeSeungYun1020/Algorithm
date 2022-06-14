/*
fib(n) {
    if (n = 1 or n = 2)
    then return 1;  # 코드1
    else return (fib(n - 1) + fib(n - 2));
}
*/
var fibCount = 0
fun fib(n: Int): Int {
    if (n == 1 || n == 2) {
        fibCount++
        return 1
    } else {
        return fib(n-1) + fib(n-2)
    }
}

/*
fibonacci(n) {
    f[1] <- f[2] <- 1;
    for i <- 3 to n
    f[i] <- f[i - 1] + f[i - 2];  # 코드2
    return f[n];
}
*/

var fibonacciCount = 0
fun fibonacci(n: Int): Int {
    val f = MutableList(n + 1) { 1 }
    for (i in 3..n) {
        f[i] = f[i-1] + f[i-2]
        fibonacciCount++
    }
    return f[n]
}

fun main() {
    val n = readln().toInt()
    fib(n)
    fibonacci(n)
    println("$fibCount $fibonacciCount")
}