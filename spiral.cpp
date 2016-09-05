// print spiral pattern based on user defined input size, N
//
// m a singer
// sept 5, 2016
//
// g++ spiral.cpp -std=c++11

#include <iostream>
#include <string>
#include <vector>

std::vector<std::vector<std::string>> pattern;

int stopCheck(int N);

int main(int argc, char* argv[]) {

  // ensure proper usage
  if(argc < 2) {
    std::cerr << "usage: spiral <int size>" << std::endl;
    return 0;
  }

  // size of spiral
  int N = atoi(argv[1]);

  // make sure size >= 0
  if(N < 0) {
    std::cerr << "size must be >= 0" << std::endl;
    return 0;
  }

  // initialize pattern
  pattern.resize(N);
  for(auto &i : pattern) {
    i.resize(N);
  }
  for(int i = 0; i < N; i++) {
    for(int j = 0; j < N; j++) {
      pattern[i][j] = " ";
    }
  }

  // initial row and column variables to start at upper-left corner
  int row = 0;
  int col = 0;

  // left to right
  for(int j = col; j < N; j++) {
    pattern[row][j] = "*";
  }
  // subtract one from max column and from N
  col = N-1;
  if(stopCheck(--N)) return 1;

  // make spiral
  while(true) {

    // top to bottom
    for(int i = row; i < N+row+1; i++) {
      pattern[i][col] = "*";
    }
    // subtract one from max row and from N
    row = (N+row+1)-1;
    if(stopCheck(--N)) return 1;

    // right to left
    for(int j = col-1; j > (col-1-N); j--) {
      pattern[row][j] = "*";
    }
    // add one to max column (since right to left) and
    // subtract one from N
    col = (col-1-N)+1;
    if(stopCheck(--N)) return 1;

    // bottom to top
    for(int i = row-1; i > (row-1-N); i--) {
      pattern[i][col] = "*";
    }
    // add one to max row (since bottom to top) and
    // subtract one from N
    row = (row-1-N)+1;
    if(stopCheck(--N)) return 1;

    // left to right
    for(int j = col; j < (N+col+1); j++) {
      pattern[row][j] = "*";
    }
    // subtract one from max column and from N
    col = (N+col+1)-1;
    if(stopCheck(--N)) return 1;

  }

  return 1;

}

int stopCheck(int N) {
  if(N < 1) {
    // print final pattern
    for(int i = 0; i < pattern.size(); i++) {
      for(int j = 0; j < pattern[i].size(); j++) {
	std::cout << pattern[i][j] << " ";
      }
      std::cout << std::endl;
    }
    return 1;
  }
  return 0;
}


