#include <iostream>
#include <algorithm>
#include <map>
#include <string>

using namespace std;

int N, M, P;

typedef pair<int,int> pii;
map<pii,int> grid;

// colouring of the dice.  The faces are indexed:
//   top, bot, front, left, right, back
int colour[6] = {0};
int dots[6] = {1, 6, 4, 5, 2, 3};   // how many dots are on each face

const string dir = "NSEW";

// if we make a move, where do the faces come from
const int move[4][6] = {
  { 2, 5, 1, 3, 4, 0 },      // N
  { 5, 2, 0, 3, 4, 1 },      // S
  { 3, 4, 2, 1, 0, 5 },      // E
  { 4, 3, 2, 0, 1, 5 }       // W
};

const int dx[4] = {0, 0, 1, -1};
const int dy[4] = {1, -1, 0, 0};

void move_dice(int di)
{
  int colour2[6], dots2[6];

  for (int i = 0; i < 6; i++) {
    colour2[i] = colour[::move[di][i]];
    dots2[i] = dots[::move[di][i]];
  }

  copy(colour2, colour2+6, colour);
  copy(dots2, dots2+6, dots);
}

int main()
{
  cin >> N >> M >> P;
  for (int i = 0; i < M; i++) {
    int x, y, T;
    cin >> x >> y >> T;
    grid[pii(x,y)] = T;
  }

  string path;
  cin >> path;

  bool good = true;
  int x = 1, y = 1;
  
  for (unsigned int i = 0; i < path.size() && good; i++) {
    int di = dir.find(path[i]);
    move_dice(di);
    x += dx[di];  y += dy[di];
    good &= 1 <= x && x <= N && 1 <= y && y <= N;
    if (grid.find(pii(x,y)) != grid.end()) {
      int C = grid[pii(x,y)];

      good &= (!colour[1] || colour[1] == C);
      colour[1] = C;
    }
    if (count(colour, colour+6, 0) == 0) break;    // all faces coloured
  }

  good &= count(colour, colour+6, 0) == 0;
  if (!good) {
    fill(colour, colour+6, 0);
  }

  int face[7];
  for (int i = 0; i < 6; i++) {
    face[dots[i]] = colour[i];
  }
  for (int i = 1; i <= 6; i++) {
    if (i > 1) cout << ' ';
    cout << face[i];
  }
  cout << endl;

  return 0;
}
