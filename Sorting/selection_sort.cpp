#include <iostream>
using namespace std;

template <typename T>
ostream &operator<<(ostream &os, vector<T> vec) {
    for(const auto& el : vec) {
        cout << el << " ";
    }
    return os;
}

void selection_sort(vector<int> &nums) {
    int n = nums.size();
    for(int i = 0; i < n - 1; ++i) {
        int min_idx = i;
        for(int j = i + 1; j < n; ++j) {
            if(nums[j] < nums[min_idx]) { min_idx = j; }
        }
        swap(nums[i], nums[min_idx]);
    }
}

int main() {
    vector<int> nums = {5, 3, 7, 1, 0, 4, 8};
    selection_sort(nums);
    cout << nums;
}