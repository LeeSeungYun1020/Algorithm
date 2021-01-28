#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {// 평균 중앙 최빈 범위
    int count;
	cin >> count;

	vector<int> num(count);
	int check[8001] = {0, };
	int sum = 0;
    for (int i = 0; i < count; ++i) {
		cin >> num[i];
		sum += num[i];
		check[4000 + num[i]]++;
    }
	int mode = 0;
	int mCount = 0;
	bool mIsSecond = false;
	for (int i = 0; i < 8001; ++i) {
		if (check[i] != 0) {
			if (mCount < check[i]) {
				mCount = check[i];
				mode = i - 4000;
				mIsSecond = false;
			} else if (mCount == check[i] && !mIsSecond) {
				mIsSecond = true;
				mode = i - 4000;
			}
		}
		
	}
	sort(num.begin(), num.end());
	cout << round(static_cast<double>(sum) / count) << '\n'
	<< num[count / 2] << '\n'
	<< mode << '\n'
	<< num[count - 1] - num[0] << '\n';
}