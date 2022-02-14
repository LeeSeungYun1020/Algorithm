#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int count;
	cin >> count;
	vector<int> num;
    for (int i = 0; i < count; ++i) {
        int n;
        cin >> n;
        num.push_back(n);
    }
    sort(num.begin(), num.end());
    for (auto value : num)
        cout << value << endl;
}