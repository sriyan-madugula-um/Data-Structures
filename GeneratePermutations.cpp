#include <iostream>
#include <deque>
#include <numeric>
#include <unistd.h>

using namespace std;

// all print in different order

// insertion operator overload for vector
template<typename T>
ostream &operator<<(ostream &os, const vector<T> &elements) {
    for(auto &el : elements) {
        os << el << " ";
    }
    return os;
}

// insertion operator overload for deque
template<typename T>
ostream &operator<<(ostream &os, const deque<T> &elements) {
    for(auto &el : elements) {
        os << el << " ";
    }
    return os;
}

// genPerms with 2 containers (stack and queue juggling)
template <typename T>
void genPerms(vector<T> &perm, deque<T> &unused) {
    if(unused.empty()) {
        cout << perm << endl;
        return;
    }
    for(unsigned k = 0; k != unused.size(); ++k) {
        perm.push_back(unused.front());
        unused.pop_front();
        genPerms(perm, unused);
        unused.push_back(perm.back());
        perm.pop_back();
    }
}

// stl next_permutation
template <typename T>
void stl_gen_perms(vector<T> &vec) {
    cout << vec << endl;
    while(next_permutation(vec.begin(), vec.end())) {
        cout << vec << endl;
    }
}

// swap helper method for genPerms2, std::swap does the same thing w/ diff parameters
template <typename T>
void swap(vector<T> &path, size_t perm_length, size_t i) {
    T temp = path[perm_length];
    path[perm_length] = path[i];
    path[i] = temp;
}

// genPerms2 with only one container (vector), better performance
template <typename T>
void genPerms2(vector<T> &path, size_t perm_length) {
    if(path.size() == perm_length) {
        cout << path << endl;
        return;
    }
    /*
    if(!promising(path, perm_length)) { // if not promising permutation, get rid of it earlier to save time
        // do smth
        return;
    }
    */
    for(size_t i = perm_length; i < path.size(); ++i) {
        std::swap(path[perm_length], path[i]);
        genPerms2(path, perm_length + 1);
        std::swap(path[perm_length], path[i]);
    }
}

int main() {
    size_t n;
    cout << "Enter n: " << flush; // time delay noticeable with usleep, outputs immediately w/ flush rather than waiting until second cout call
    //usleep(5000000);
    while(!(cin >> n)) { // keep going while no integer
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cout << "Enter n: " << flush;
    }

    vector<size_t> perm;
    deque<size_t> unused(n); // deque of size n
    iota(unused.begin(), unused.end(), 1); // 1, 2, ..., n
    genPerms(perm, unused); // slower with 2 containers

    cout << endl;

    vector<size_t> vec(n);
    iota(vec.begin(), vec.end(), 1); 
    stl_gen_perms(vec); // stl

    cout << endl;

    vector<size_t> a(n);
    iota(a.begin(), a.end(), 1);
    genPerms2(a, 0); // faster w/ one container

    return 0;
}