#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;

    int* input = new int[n];
    int max = 0;
    for (int i = 0; i < n; ++i) {
        cin >> input[i];
        if (input[i] > max)
            max = input[i];
    }

    auto* divisor = new long long[max + 1];
    divisor[0] = 0;
    for (int i = 1; i <= max; ++i) {
        divisor[i] = 1;
    }

    for (int i = 2; i <= max; ++i) {
        for (int j = 1; j <= max; ++j) {
            long long k = i;
            if (k * j <= max) {
                divisor[i * j] += i;
            } else break;
        }
    }


    for (int i = 2; i <= max; ++i) {
        divisor[i] += divisor[i-1];
    }

    for (int i = 0; i < n; ++i) {
        cout << divisor[input[i]] << '\n';
    }

    return 0;
}
