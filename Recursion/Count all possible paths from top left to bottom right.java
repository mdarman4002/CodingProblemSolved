/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    static int row = 3, col = 3;
	public static void main(String[] args) {
		System.out.println("sourceToDest");
		System.out.println(sourceToDest(0,0));
		System.out.println("destinationToSource");
		System.out.println(destinationToSource(3,3));
	}
	// source to destination
	public static int sourceToDest(int r, int c){
	    if(r == row-1 || c == col-1){
	        return 1;
	    }
	    return sourceToDest(r+1,c) + sourceToDest(r,c+1);
	}
	//destination to source
	public static int destinationToSource(int r, int c){
	    if(r == 1|| c == 1){
	        return 1;
	    }
	    return destinationToSource(r-1, c) + destinationToSource(r,c-1);
	}
}
