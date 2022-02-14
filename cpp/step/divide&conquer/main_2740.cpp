#include <iostream>
using namespace std;

void readMatrix(int**& matrix, const int a, const int b) {
	matrix = new int* [a];
	for (int i = 0; i < a; ++i) {
		matrix[i] = new int[b] { 0, };
		for (int j = 0; j < b; ++j) {
			cin >> matrix[i][j];
		}
	}
}

void printMatrix(int**& matrix, const int a, const int b) {
	for (int i = 0; i < a; ++i) {
		for (int j = 0; j < b; ++j) {
			cout << matrix[i][j] << ' ';
		}
		cout << '\n';
	}
}

int main() {
	int n, m, k;
	int** matA;
	int** matB;
	cin >> n >> m;
	readMatrix(matA, n, m);
	cin >> m >> k;
	readMatrix(matB, m, k);
	
	int** result = new int*[n];
	for (int i = 0; i < n; ++i) {
		result[i] = new int[k] { 0, };
		for (int j = 0; j < m; ++j) {
			const int tem = matA[i][j];
			for (int l = 0; l < k; ++l) {
				result[i][l] += tem * matB[j][l];
			}
		}
	}
	
	printMatrix(result, n, k);
}
