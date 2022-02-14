#include <iostream>
#include <cmath>

using namespace std;

int main() {
    double a, b, c;
    cin >> a >> b >> c;
    cout << static_cast<int>(ceil((c - a) / (a - b))) + 1 << endl;
}