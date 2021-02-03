#include <iostream>
#include <deque>
#include <string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	int count;
	cin >> count;
	for (int i = 0; i < count; ++i) {
		string command;
		cin >> command;
		int num;
		cin >> num;
		string arr;
		cin >> arr;
		deque<int> deq;
		if (arr != "[]") {
			arr.erase(0, 1);
			arr.pop_back();
			int start = 0;
			int end;
			while ((end = arr.find(',', start)) != string::npos) {
				deq.push_back(stoi(arr.substr(start, end - start)));
				start = end + 1;
			}
			deq.push_back(stoi(arr.substr(start)));
		}

		bool isReverse = false;
		bool isRight = true;
		for (auto c : command) {
			if (c == 'R') {
				isReverse = !isReverse;
			} else if (c == 'D') {
				if (deq.empty()) {
					isRight = false;
					break;
				}
				if (isReverse) {
					deq.pop_back();
				} else {
					deq.pop_front();
				}
			}
		}
		if (isRight) {
			cout << '[';
			if (!deq.empty()) {
				if (isReverse) {
					while (deq.size() > 1) {
						cout << deq.back() << ',';
						deq.pop_back();
					}
					cout << deq.back();
				} else {
					while (deq.size() > 1) {
						cout << deq.front() << ',';
						deq.pop_front();
					}
					cout << deq.front();
				}
			}

			cout << "]\n";
		} else {
			cout << "error\n";
		}
	}
}
