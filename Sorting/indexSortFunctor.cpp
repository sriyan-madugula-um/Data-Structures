#include <iostream>
using namespace std;

template<typename T>
ostream &operator<<(ostream &os, const vector<T> &elements) {
    for(auto &el : elements) {
        os << el << " ";
    }
    return os;
}

class SortByCoord {
    const vector<double> &coords;

    public:
    SortByCoord(const vector<double> &z) : coords(z) {}
    bool operator()(size_t i, size_t j) {
        return coords[i] < coords[j];
    }
};


int main() {
    vector<size_t> idx(10);
    vector<double> xCoord(10);

    for(size_t k = 0; k != 10; ++k) {
        idx[k] = k;
        xCoord[k] = rand() % 1000 / 10;
    }

    cout << idx << endl;
    cout << xCoord << endl;

    SortByCoord sbx(xCoord);
    cout << endl;
    // cout << idx << endl;
    // cout << xCoord << endl;

    sort(begin(idx), end(idx), sbx);
    cout << idx << endl;
    cout << xCoord << endl;
}