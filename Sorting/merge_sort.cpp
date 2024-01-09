#include <iostream>
using namespace std;


template <typename T>
ostream &operator<<(ostream &os, vector<T> vec) {
    for(const auto& el : vec) {
        cout << el << " ";
    }
    return os;
}

void merge(vector<int> &nums, int start, int mid, int end) {
    int n1 = mid - start + 1;
    int n2 = end - mid;

    vector<int> left(n1);
    vector<int> right(n2);

    // copy into left and right temp vectors, to be copied back into nums later
    for(int i = 0; i < n1; ++i) { 
        left[i] = nums[start + i];
    }

    for(int i = 0; i < n2; ++i) {
        right[i] = nums[mid + 1 + i];
    }

    int i = 0; // left vector index
    int j = 0; // right vector index
    int k = start; // nums index

    while(i < n1 && j < n2) { // fill left and right vectors sorted
        if(left[i] < right[j]) {
            nums[k] = left[i];
            ++i;
        }
        else {
            nums[k] = right[j];
            ++j;
        }
        ++k;
    }

    // one of them likely won't be filled, look at while loop above
    while(i < n1) {
        nums[k] = left[i];
        ++i;
        ++k;
    }

    while(j < n2) {
        nums[k] = right[j];
        ++j;
        ++k;
    }
    //cout << nums << endl;
}

void merge_sort(vector<int> &nums, int start, int end) {
    if(start < end) { // !=
        int mid = start + (end - start) / 2;
        merge_sort(nums, start, mid); // you're not actually splitting them, just viewing parts with indices pointing to start, middle, end
        merge_sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }
}

void mergesort(vector<int> &nums) {
    merge_sort(nums, 0, nums.size() - 1);
}

int main() {
    vector<int> nums = {5, 3, 7, 1, 6, 4, 8};
    mergesort(nums);
    cout << nums;
}