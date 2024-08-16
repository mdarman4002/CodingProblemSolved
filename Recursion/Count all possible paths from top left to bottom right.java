
public class Main
{
	public static void main(String[] args) {
	
	    System.out.println(destinationToSource(3,3));
	    System.out.println(sourceToDest(3,3));
	}
	// destination to source
	public static int destinationToSource(int r, int c){
	    if(r==0 || c == 0){
	        return 1;
	    }
	    return destinationToSource(r,c-1) + destinationToSource( r-1,c);
	}
	//source to destination
	public static int sourceToDest(int r, int c) {
    // Check for invalid indices
    if (r < 0 || c < 0) {
        return 0;
    }
    // Base case: If we are at the destination (0, 0), return 1
    if (r == 0 && c == 0) {
        return 1;
    }
    // Recursive case: Move right or down
    return sourceToDest(r - 1, c) + sourceToDest(r, c - 1);
}

}
