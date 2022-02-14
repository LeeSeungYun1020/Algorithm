#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

int main() {
	int count;
	cin >> count;
	for (int i = 0; i < count; ++i) {
		int num;
		cin >> num;
		map<string, int> clothes;
		for (int i = 0; i < num; ++i) {
			string name, type;
			cin >> name >> type;
			if (clothes.find(type) != clothes.end()) {
				clothes[type]++;
			} else {
				clothes[type] = 1;
			}
			
		}
		int ans = 1;
		for (auto && cloth : clothes) {
			ans *= (cloth.second + 1);
		}
		cout << ans - 1 << '\n';
	}
}