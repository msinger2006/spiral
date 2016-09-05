// print spiral pattern based on user defined size, N
//
// m a singer
// sept 4, 2016

public class spiral {

    public static void main(String[] args) {

	if(args.length < 1) {
	    System.err.println("usage: java spiral <int size>");
	    System.exit(0);
	}

	int N = Integer.parseInt(args[0]);
	int NN = N;

	String[][] pattern = new String[NN][NN];

	// initialize stuff
	for(int i = 0; i < N; i++) {
	    for(int j = 0; j < N; j++) {
		pattern[i][j] = " ";
	    }
	}

	int row = 0;
	int col = 0;

	// first outer layer of spiral; seems to be special case,
	// though could probably think harder to incorporate it
	// into algorithm below

	// left to right
	for(int j = col; j < N; j++) {
	    pattern[row][j] = "*";
	}
	col = N-1;
	N -= 1;

	// top to bottom
	for(int i = row; i < N; i++) {
	    pattern[i+1][col] = "*";
	}
	row = N-1+1;
	N -= 1;

	// right to left
	for(int j = col-1; j > (col-1-N); j--) {
	    pattern[row][j] = "*";
	}
	col = col-1-N+1;
	N -= 1;

	// bottom to top
	for(int i = row-1; i > (row-1-N); i--) {
	    pattern[i][col] = "*";
	}
	row = row-1-N+1;
	N -= 1;

	// interior of spiral
	while(true) {

	    // left to right
	    for(int j = col; j < (N+col+1); j++) {
		pattern[row][j] = "*";
	    }
	    col = (N+col+1)-1;
	    N -= 1;
	    if(N < 1) {
		break;
	    }

	    // top to bottom
	    for(int i = row; i < N+row+1; i++) {
		pattern[i][col] = "*";
	    }
	    row = (N+row+1)-1;
	    N -= 1;
	    if(N < 1) {
		break;
	    }

	    // right to left
	    for(int j = col-1; j > (col-1-N); j--) {
		pattern[row][j] = "*";
	    }
	    col = (col-1-N)+1;
	    N -= 1;
	    if(N < 1) {
		break;
	    }

	    // bottom to top
	    for(int i = row-1; i > (row-1-N); i--) {
		pattern[i][col] = "*";
	    }
	    row = (row-1-N)+1;
	    N -= 1;
	    if(N < 1) {
		break;
	    }
	}

	// print final pattern
	for(int i = 0; i < NN; i++) {
	    for(int j = 0; j < NN; j++) {
		System.out.print(pattern[i][j] + " ");
		System.out.flush();
	    }
	    System.out.println("");
	    System.out.flush();
	}

	System.out.flush();

    }
}

