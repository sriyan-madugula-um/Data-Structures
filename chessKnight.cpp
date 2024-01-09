#include <iostream>
#include <queue>
#include <unordered_set>
using namespace std;

// put initial in queue and visited
// while queue is not empty,
// store the front item in queue
// pop front item
// do what we need to do (print, check)
// for all adjacent nodes not already in visited,
// add them to queue and visited

struct Position { // can also use tuple<int, int, int> (bottom)
    int row;
    int col;
    int moves;
};

int min_moves(int n, int startRow, int startCol, int endRow, int endCol) {
    // checks if row and col are a valid position on the chessboard
    auto is_valid = [&](int x, int y) {
        return 0 <= x && x <= n && 0 <= y && y <= n;
    };

    // possible moves for knight
    int moves[8][2] = {{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {-2, -1}, {-2, 1}};

    // queue for BFS - BFS needed b/c we must find first possible path from start node, which will be the shortest path from start node to destination
    queue<Position> q;
    q.push({startRow, startCol, 0});

    // stores visited locations (as grid position) on the board
    unordered_set<int> visited;
    visited.insert(startRow * n + startCol);

    while(!q.empty()) {
        Position curr = q.front();
        q.pop();

        // if we reached destination
        if(curr.row == endRow && curr.col == endCol) {
            return curr.moves;
        }

        // explore all moves
        for(auto &move : moves) {
            int new_row = curr.row + move[0];
            int new_col = curr.col + move[1];
            int position = new_row * n + new_col;
            
            // valid position and not already visited
            if(is_valid(new_row, new_col) && visited.find(position) == visited.end()) {
                // add to queue and visited
                q.push({new_row, new_col, curr.moves + 1});
                visited.insert(position);
            }
        }
    }
    // no valid path found
    return -1;
}

int main() {
    int n = min_moves(8, 0, 0, 7, 6);
    cout << n << "\n";
}

// Using tuple instead of Position struct, get<0>(curr) also possible

// int min_moves(int n, int startRow, int startCol, int endRow, int endCol) {
//     auto is_valid = [&](int x, int y) {
//         return 0 <= x && x < n && 0 <= y && y < n;
//     };

//     int moves[8][2] = {{2, 1}, {2, -1}, {1, 2}, {1, -2}, {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}};

//     queue<tuple<int, int, int>> q;
//     q.push({startRow, startCol, 0});
    
//     unordered_set<int> visited;
//     visited.insert(startRow * n + startCol);

//     while(!q.empty()) {
//         auto [curr_row, curr_col, curr_moves] = q.front();
//         q.pop();

//         if(curr_row == endRow && curr_col == endCol) {
//             return curr_moves;
//         }

//         for(auto &move : moves) {
//             int next_row = curr_row + move[0];
//             int next_col = curr_col + move[1];
//             int next_moves = curr_moves + 1;
//             int next_position = next_row * n + next_col;
//             q.push({next_row, next_col, next_moves});
//             visited.insert(next_position);
//         }
//     }
//     return -1;
// }