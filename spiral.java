// print spiral pattern based on user defined size, N
//
// m a singer
// sept 4, 2016

public class spiral {

    public static void main(String[] args) {

	// ensure proper usage
	if(args.length < 1) {
	    System.err.println("usage: java spiral <int size>");
	    System.exit(0);
	}

	// size of spiral
	int N  = 0;
	try {
	    N = Integer.parseInt(args[0]);
	}
	catch(NumberFormatException nfe) {
	    System.err.println("size of sprial must be an integer >= 0");
	    System.exit(0);
	}

	// make sure size >= 0
	if(N < 0) {
	    System.err.println("size must be >= 0");
	    System.exit(0);
	}

	String[][] pattern = new String[N][N];

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
	for(int i = 0; i < pattern.length; i++) {
	    for(int j = 0; j < pattern.length; j++) {
		System.out.print(pattern[i][j] + " ");
	    }
	    System.out.println("");
	}

    }
}

