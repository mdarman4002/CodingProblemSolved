/**
 * This class provides a solution to the problem of finding all paths from the source node to the target node in a directed acyclic graph (DAG).
 */
class Solution {
    /**
     * This method returns all paths from the source node (0) to the target node (n-1) in the given graph.
     * 
     * @param graph The input graph represented as an adjacency list.
     * @return A list of lists, where each inner list represents a path from the source node to the target node.
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> output = new ArrayList<>(); // Initialize an empty list to store all paths.
        boolean visited[]  = new boolean[graph.length]; // Initialize a boolean array to keep track of visited nodes.
        findAllPath(graph, 0, graph.length-1, output, new ArrayList<>(), visited); // Call the helper method to find all paths.
        return output; // Return the list of all paths.
    }

    /**
     * This is a helper method to find all paths from the source node to the target node using depth-first search (DFS).
     * 
     * @param graph The input graph represented as an adjacency list.
     * @param source The current node being visited.
     * @param destination The target node.
     * @param output The list of all paths found so far.
     * @param cur The current path being explored.
     * @param visited A boolean array to keep track of visited nodes.
     */
    public void findAllPath(int[][] graph, int source, int destination, List<List<Integer>> output, ArrayList<Integer> cur, boolean visited[]){
        cur.add(source); // Add the current node to the current path.
        if(source == destination){ // If the current node is the target node, add the current path to the output list.
            output.add(new ArrayList(cur));
        }
        visited[source] = true; // Mark the current node as visited.
        for(int neighbour : graph[source]){ // Iterate over the neighbors of the current node.
            if(!visited[neighbour]){ // If a neighbor has not been visited, recursively call the helper method.
                findAllPath(graph, neighbour, destination, output, cur, visited);
            }
        }
        cur.remove(cur.size()-1); // Remove the current node from the current path (backtracking).
        visited[source] = false; // Unmark the current node as visited (backtracking).
    }
}
