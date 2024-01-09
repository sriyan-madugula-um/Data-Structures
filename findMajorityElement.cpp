#include <iostream>
#include <vector>
using namespace std;

// finds majority element (appears >50% of the time) in O(n) time and O(1) space
// and for >33%, uses two candidates (returns 1 or 2 elements)
// assuming there is a valid input

int findMajorityElement(const vector<int>& nums) {
    int candidate = 0;
    int count = 0;

    for (int num : nums) {
        if (count == 0) {
            candidate = num;
            count = 1;
        }
        else if (num == candidate) {
            count += 1;
        } else {
            count -= 1;
        }
        // if there are more of this element than other elements (>50%), 
        // then count will remain positive
        // otherwise, candidate goes to a new element
    }

    // At this point, candidate is a potential majority element
    // may want to perform a second pass to confirm it occurs more than 50% of the time

    return candidate;
}

// 33% uses two candidates b/c there can be 2 candidates with over 33% 
vector<int> find33Element(const vector<int>& nums) {
    int candidate1 = 0;
    int count1 = 0;

    int candidate2 = 0;
    int count2 = 0;

    for (int num : nums) {
        if (count1 == 0) {
            candidate1 = num;
            count1 = 1;
        }
        else if (count2 == 0) {
            candidate2 = num;
            count2 = 1;
        }
        else if (num == candidate1) {
            count1 += 1;
        }
        else if (num == candidate2) {
            count2 += 1;
        } 
        else {
            count1 -= 1;
            count2 -= 1;
        }
    }

    count1 = 0; count2 = 0;
    for(int num : nums) {
        if(num == candidate1)
            count1++;
        if(num == candidate2)
            count2++;
    }
    
    vector<int> res;
    int n = nums.size();
    // cout << candidate1 << endl;
    // cout << candidate2 << endl;
    if(count1 > n/3)
        res.push_back(candidate1);
    if(count2 > n/3 && candidate2 != candidate1)
        res.push_back(candidate2);
    
    return res;
}

int main() {
    vector<int> nums = {11, 11, 7, 22, 22, 22, 12, 33, 22}; 
    int majorityElement = findMajorityElement(nums);

    cout << "Majority Element: " << majorityElement << endl;

    vector<int> majorityElements = find33Element(nums);
    cout << ">33% elements: ";
    for(int num : majorityElements)
        cout << num << " ";
    return 0;
}
