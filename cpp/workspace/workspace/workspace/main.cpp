#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int a, b, c;
    cin >> a >> b >> c;
    if (c - b <= 0)
        cout << -1 << endl;
    else {
        int ans = ceil(static_cast<double>(a) / (c - b));
        if (ans * (c - b) == a)
            cout << ans + 1 << endl;
        else
            cout << ans << endl;
    }
}