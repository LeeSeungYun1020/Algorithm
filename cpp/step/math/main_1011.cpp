#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int count;
    cin >> count;
    for (int i = 0; i < count; ++i) {
        double x, y;
        cin >> x >> y;
        double d = y - x;
        int even = even = ceil(sqrt(4 * d + 1) - 1);
        int odd = ceil(2 * sqrt(d) - 1);
        if (even % 2 != 0)
            even++;
        if (odd % 2 == 0)
            odd++;
        if (even > odd)
            cout << odd << endl;
        else
            cout << even << endl;
    }
}