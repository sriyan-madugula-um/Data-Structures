#include <iostream>
using namespace std;

template <typename T>
ostream &operator<<(ostream &os, vector<T> vec) {
    for(const auto& el : vec) {
        cout << el << " ";
    }
    return os;
}

void insertion_sort(vector<int> &nums) {
    int n = nums.size();
    for(int i = 1; i < n; ++i) {
        int j = i;
        while(j > 0 && nums[j] < nums[j-1]) {
            swap(nums[j], nums[j-1]);
            --j;
        }
    }
}

int main() {
    vector<int> nums = {5, 3, 7, 1, 0, 4, 8};
    insertion_sort(nums);
    cout << nums;
}