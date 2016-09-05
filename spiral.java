// print spiral pattern based on user defined input size, N
//
// m a singer
// sept 5, 2016

public class spiral {

    // string array to hold pattern
    private static String[][] pattern;

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

	// initialize pattern
	pattern = new String[N][N];
	for(int i = 0; i < N; i++) {
	    for(int j = 0; j < N; j++) {
		pattern[i][j] = " ";
	    }
	}

	// initial row and col variables to start at upper-left corner
	int row = 0;
	int col = 0;

	// left to right
	for(int j = col; j < N; j++) {
	    pattern[row][j] = "*";
	}
	// subtract one from max column and from N
	col = N-1;
	stopCheck(--N);

	// make spiral
	while(true) {

	    // top to bottom
	    for(int i = row; i < N+row+1; i++) {
		pattern[i][col] = "*";
	    }
	    // subtract one from max row and from N
	    row = (N+row+1)-1;
	    stopCheck(--N);

	    // right to left
	    for(int j = col-1; j > (col-1-N); j--) {
		pattern[row][j] = "*";
	    }
	    // add one to max column (since right to left) and
	    // subtract one from N
	    col = (col-1-N)+1;
	    stopCheck(--N);

	    // bottom to top
	    for(int i = row-1; i > (row-1-N); i--) {
		pattern[i][col] = "*";
	    }
	    // add one to max row (since bottom to top) and
	    // subtract one from N
	    row = (row-1-N)+1;
	    stopCheck(--N);

	    // left to right
	    for(int j = col; j < (N+col+1); j++) {
		pattern[row][j] = "*";
	    }
	    // subtract one from max column and from N
	    col = (N+col+1)-1;
	    stopCheck(--N);

	}

    }

    // check to see if the spiral is complete; if so, print it
    // to standard out
    private static void stopCheck(int N) {
	if(N < 1) {
	    // print final pattern
	    for(int i = 0; i < pattern.length; i++) {
		for(int j = 0; j < pattern.length; j++) {
		    System.out.print(pattern[i][j] + " ");
		}
		System.out.println("");
	    }
	    // all done
	    System.exit(1);
	}
    }

}

