#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Point {
	int x, y;
public:
	Point(int x = 0, int y = 0): x(x), y(y) {}

	bool operator<(const Point& p) const {
		if (y > p.y) {
			return false;
		} else if (y == p.y) {
			if (x >= p.x) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}
	
	friend ostream& operator<<(ostream& os, const Point& point) {
		os << point.x << ' ' << point.y;
		return os;
	}
};

int main() {
	int count;
	cin >> count;

	vector<Point> points(count);
	int x, y;
	for (int i = 0; i < count; ++i) {
		cin >> x >> y;
		points[i] = Point(x, y);
	}
	sort(points.begin(), points.end());
	for (auto && point : points) {
		cout << point << '\n';
	}
}