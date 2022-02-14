#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
	string a, b;
	cin >> a >> b;

	const int aLen = a.length(), bLen = b.length();
	if (aLen <= 18 && bLen <= 18) {
		cout << stoull(a) + stoull(b) << endl;
		return 0;
	}

	vector<string> sum;
	int aPos = aLen, bPos = bLen;
	int carry = 0;
	while (true) {
		aPos -= 18;
		bPos -= 18;
		unsigned long long aNum = 0, bNum = 0;
		if (aPos >= 0) {
			aNum = stoull(a.substr(aPos, 18));
		} else if (aPos > -18) {
			aNum = stoull(a.substr(0, 18 + aPos));
		}
		if (bPos >= 0) {
			bNum = stoull(b.substr(bPos, 18));
		} else if (bPos > -18) {
			bNum = stoull(b.substr(0, 18 + bPos));
		}
		aNum += (bNum + carry);
		if (aNum >= 1000000000000000000) {
			aNum -= 1000000000000000000;
			carry = 1;
		} else
			carry = 0;
		sum.push_back(to_string((aNum)));
		if (aPos < 0 && bPos < 0) {
			break;
		}
	}
	cout << sum.back();
	sum.pop_back();

	
	for (auto it = sum.rbegin(); it != sum.rend(); ++it) {
		for (int i = it->length(); i < 18; ++i) {
			cout << 0;
		}
		cout << *it;
	}
}
