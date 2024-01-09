#include <iostream>
#include <queue>
#include <unordered_set>
using namespace std;

struct Position { 
    int row;
    int col;
    int moves;
    Position* parent; // makes it possible to find path
};

void print_path(Position* end) {
    vector<Position*> path;
    while(end) {
        path.push_back(end);
        end = end->parent;
    }

    for(auto it = path.rbegin(); it != path.rend(); ++it) {
        cout << "(" << (*it)->row << ", " << (*it)->col << ")" << " ";
    }
    cout << endl;
}

int min_moves(int n, int startRow, int startCol, int endRow, int endCol) {
    // checks if row and col are a valid position on the chessboard
    auto is_valid = [&](int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    };

    // possible moves for knight
    int moves[8][2] = {{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {-2, -1}, {-2, 1}};

    // queue for BFS - BFS needed b/c we must find first possible path from start node, which will be the shortest path from start node to destination
    queue<Position*> q;
    Position* start = new Position{startRow, startCol, 0, nullptr};
    q.push(start);

    // stores visited locations (as grid position) on the board
    unordered_set<int> visited;
    visited.insert(startRow * n + startCol);

    while(!q.empty()) {
        Position* curr = q.front();
        q.pop();

        // if we reached destination
        if(curr->row == endRow && curr->col == endCol) {
            print_path(curr);
            return curr->moves;
        }

        // explore all moves
        for(auto &move : moves) {
            int new_row = curr->row + move[0];
            int new_col = curr->col + move[1];
            int position = new_row * n + new_col;
            
            // valid position and not already visited
            if(is_valid(new_row, new_col) && visited.find(position) == visited.end()) {
                // add to queue and visited
                Position* next = new Position{new_row, new_col, curr->moves + 1, curr};
                q.push(next);
                visited.insert(position);
            }
        }
    }
    // no valid path found
    return -1;
}

int main() {
    cout << "Enter the square dimension of the chess board: ";
    size_t n; cin >> n;
    cout << "Enter knight's current location: ";
    size_t currX; size_t currY;
    cin >> currX; cin >> currY;
    cout << "Enter the destination location: ";
    size_t destX; size_t destY;
    cin >> destX; cin >> destY;
    size_t moves = min_moves(n, currX, currY, destX, destY);
    cout << "Minimum moves: " << moves << "\n";
}