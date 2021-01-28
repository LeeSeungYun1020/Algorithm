#include <iostream>

using namespace std;

void mergeSort(int* old, int low, int high, int* tem) {
	if (low >= high)
        return;

	int mid = (low + high) / 2;
    mergeSort(old, low, mid, tem);
    mergeSort(old, mid + 1, high, tem);

    int i = low;
    int j = mid + 1;
    int k = low;
	while (k <= high) {
		if (i == mid + 1) {
            tem[k] = old[j++];
		} else if (j == high + 1) {
            tem[k] = old[i++];
		} else if (old[i] < old[j]) {
            tem[k] = old[i++];
		} else {
            tem[k] = old[j++];
		}
        k++;
	}

	for (int l = low; l <= high; ++l) {
        old[l] = tem[l];
	}
}

int main() {
    int count;
	cin >> count;
    int* num = new int[count];
    int* tem = new int[count];
    for (int i = 0; i < count; ++i) {
        cin >> num[i];
    }
    mergeSort(num, 0, count - 1, tem);
    for (int i = 0; i < count; ++i) {
        cout << num[i] << '\n';
    }

    delete[] num;
    delete[] tem;
}