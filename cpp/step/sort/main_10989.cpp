#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int main() {
    int count;
	cin >> count;
    int checker[10001] = {0, };
	int tem;
    for (int i = 0; i < count; ++i) {
        scanf("%d", &tem);
        checker[tem]++;
    }
    ios_base::sync_with_stdio(false);
    for (int i = 0; i < 10001; ++i) {
	    for (int j = 0; j < checker[i]; ++j) {
            cout << i << '\n';
	    }
    }
}