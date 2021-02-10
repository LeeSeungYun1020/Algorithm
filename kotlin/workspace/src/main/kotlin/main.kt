import kotlin.math.max
import kotlin.math.min

fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }
    val dp = Array(n + 1) { IntArray(it / 2 + 1) { 1 } }
    for (i in 2..n) {
        for (j in 1..i/2) {
            dp[i][j] = (dp[i-1][j-1] + dp[i-1][min(j, i - j - 1)]) % 1_000_000_007
        }
    }
    print(dp[n][min(k, n - k)])
}
/*const long long p = 1000000007;
long factorial[4000000];
long x_after, x_before, temp, q;

void euclidean(long p,long B) {
    if (p%B > 0) {
        euclidean(B, p%B);
        temp = x_after;
        x_after = x_before - (p/B)*x_after;
        x_before = temp;
    }
    else {
        x_after = 1;
        x_before = 0;
    }
}

int main() {
    int N, K;
    std::cin >> N >> K;
    factorial[0] = factorial[1] = 1;
    for (int i = 2; i <= N; i++)
        factorial[i] = (factorial[i - 1] * i) % p;

    long B = (factorial[K] * factorial[N - K]) % p;

    euclidean(p, B);
    long result = ((factorial[N] % p)* (x_after%p)) % p;
    if (result < 0) result += p;
    std::cout << result << std::endl;
}*/