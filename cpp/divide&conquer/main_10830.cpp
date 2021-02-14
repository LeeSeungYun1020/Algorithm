#include <iostream>
using namespace std;

class Matrix {
	int n, m;
	int** matrix;
public:
	Matrix(const int n, const int m) : n(n), m(m) {
		matrix = new int*[n];
		for (int i = 0; i < n; ++i) {
			matrix[i] = new int[m];
			for (int j = 0; j < m; ++j) {
				cin >> matrix[i][j];
				matrix[i][j] %= 1000;
			}
		}
	}

	Matrix(int** matrix, const int n, const int m): n(n), m(m), matrix(matrix) {}

	Matrix(const Matrix& copy): n(copy.n), m(copy.m) {
		matrix = new int*[n];
		for (int i = 0; i < n; ++i) {
			matrix[i] = new int[m];
			for (int j = 0; j < m; ++j) {
				matrix[i][j] = copy.matrix[i][j];
			}
		}
	}

	~Matrix() {
		for (int i = 0; i < n; ++i) {
			delete[] matrix[i];
		}
		delete[] matrix;
	}

	Matrix& operator=(const Matrix& copy) {
		if (this == &copy) {
			return *this;
		}

		for (int i = 0; i < n; ++i) {
			delete[] matrix[i];
		}
		delete[] matrix;
		n = copy.n;
		m = copy.m;
		matrix = new int*[n];
		for (int i = 0; i < n; ++i) {
			matrix[i] = new int[m];
			for (int j = 0; j < m; ++j) {
				matrix[i][j] = copy.matrix[i][j];
			}
		}
		return *this;
	}

	Matrix& operator=(Matrix copy) noexcept {
		if (this == &copy) {
			return *this;
		}
		swap(n, copy.n);
		swap(m, copy.m);
		swap(matrix, copy.matrix);
		return *this;
	}

	Matrix operator*(const Matrix& other) const {
		int** result = new int*[n];
		for (int i = 0; i < n; ++i) {
			result[i] = new int[other.m]{0,};
			for (int j = 0; j < m; ++j) {
				const int tem = matrix[i][j];
				for (int l = 0; l < other.m; ++l) {
					result[i][l] = (result[i][l] + tem * other.matrix[j][l]) % 1000;
				}
			}
		}
		return Matrix(result, n, other.m);
	}

	Matrix operator^(const long long k) const {
		if (k == 1) {
			return *this;
		}
		const auto tem = *this ^ (k / 2);
		if (k % 2 == 0) {
			return tem * tem;
		}
		return tem * tem * *this;
	}

	friend ostream& operator<<(ostream& os, const Matrix& m) {
		for (int i = 0; i < m.n; ++i) {
			for (int j = 0; j < m.m; ++j) {
				os << m.matrix[i][j] << ' ';
			}
			os << '\n';
		}
		return os;
	}
};

int main() {
	int n;
	cin >> n;
	long long k;
	cin >> k;
	Matrix m(n, n);
	cout << (m ^ k);
}
