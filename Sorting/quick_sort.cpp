#include <iostream>
#include <algorithm>
#include <random>
using namespace std;

template <typename T>
ostream &operator<<(ostream &os, vector<T> &vec) {
    for(const auto& el : vec) {
        cout << el << " ";
    }
    return os;
}

int partition(vector<int> &nums, int start, int end) {
    int pivot_idx = start + (end - start) / 2;
    swap(nums[pivot_idx], nums[end]);
    pivot_idx = end;

    int left_idx = start;
    int right_idx = end - 1;

    while(left_idx <= right_idx) { // break when left_idx strictly > right_idx
        if(nums[left_idx] < nums[pivot_idx]) {
            left_idx++;
        }
        else if(nums[right_idx] > nums[pivot_idx]) {
            right_idx--;
        }
        else {
            if(left_idx > right_idx) {
                break;
            }
            else {
                swap(nums[left_idx], nums[right_idx]);
                left_idx++; // = start is slower b/c you already checked the previous ones
                right_idx--; // = end - 1 is slower b/c you already checked the previous ones
            }
        }
    }

    swap(nums[pivot_idx], nums[left_idx]);
    return left_idx;
}

void quick_sort(vector<int> &nums, int start, int end) {
    if(start < end) {
        int partition_idx = partition(nums, start, end);
        quick_sort(nums, start, partition_idx - 1);
        quick_sort(nums, partition_idx + 1, end);
    }
}

void quicksort(vector<int> &nums) {
    quick_sort(nums, 0, nums.size() - 1);
}

bool is_sorted(vector<int> &vec) {
    for(int i = 0; i < vec.size() - 1; ++i) {
        if(vec[i] > vec[i + 1]) { return false; }
    }
    return true;
}

int main() {
    vector<int> nums = {5, 3, 7, 1, 6, 4, 8};
    quicksort(nums);
    cout << nums << endl;

    // STRESS TESTING:
    // random vec size
    // random numbers in vector
    // random shuffling

    random_device rd;
    mt19937_64 mt(rd());
    uniform_int_distribution<mt19937_64::result_type> dist20(1,20);
    
    for(int i = 0; i < 100; ++i) {
        int size = dist20(mt); // random vec size (1-20)
        vector<int> vec(size);

        for(auto &e : vec) {
            e = dist20(mt); // filled with random numbers in vector (1-20)
        }

        // each vector is shuffled n times
        for(int i = 0; i < vec.size(); ++i) {
            shuffle(begin(vec), end(vec), mt); // shuffle
            quicksort(vec);
            if(!is_sorted(vec)) { cout << "problem" << endl; };
        }
    }
    cout << "nice" << endl;

}