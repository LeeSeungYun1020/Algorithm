#include <iostream>
#include <vector>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int n, tem;
	cin >> n;
	vector<int> subList{0};
	for (int i = 0; i < n; ++i) {
		cin >> tem;
		if (subList.back() < tem) {
			subList.push_back(tem);
		} else {
			subList[lower_bound(subList.begin(), subList.end(), tem) - subList.begin()] = tem;
		}
	}
	cout << subList.size() - 1;
}
