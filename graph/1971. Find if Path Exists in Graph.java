class Solution {
    /**
     * Returns true if there is a valid path from source to destination in the graph.
     * 
     * @param n           number of nodes in the graph
     * @param edges       list of edges in the graph
     * @param source      source node
     * @param destination destination node
     * @return true if there is a valid path, false otherwise
     */
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create an adjacency list representation of the graph
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Populate the adjacency list
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Create a visited array to keep track of visited nodes
        boolean visited[] = new boolean[n];

        // Perform DFS from the source node
        boolean found = dfs(adjList, source, destination, visited);

        return found;
    }

    /**
     * Performs a Depth-First Search from the given node.
     * 
     * @param adjList     adjacency list representation of the graph
     * @param node        current node
     * @param destination destination node
     * @param visited     visited array
     * @return true if the destination node is found, false otherwise
     */
    public boolean dfs(ArrayList<ArrayList<Integer>> adjList, int node, int destination, boolean visited[]) {
        // Mark the current node as visited
        visited[node] = true;

        // If the current node is the destination node, return true
        if (node == destination) {
            return true;
        }

        // Explore the neighbours of the current node
        for (int neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {
                // Recursively call dfs on the neighbour
                boolean found = dfs(adjList, neighbour, destination, visited);
                if (found) {
                    return true;
                }
            }
        }

        // If no path is found, return false
        return false;
    }
}


public static void main(String[] args) {
    Solution solution = new Solution();
    int n = 6;
    int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
    int source = 0;
    int destination = 5;

    boolean isValidPath = solution.validPath(n, edges, source, destination);
    System.out.println("Is valid path: " + isValidPath); // Output: true
}
