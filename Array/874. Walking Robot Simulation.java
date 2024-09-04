/**
 * This class provides a solution to the robot simulation problem.
 * The robot can move forward, turn left, or turn right based on a set of commands.
 * The robot's movement is restricted by a set of obstacles.
 */
class Solution {
    /**
     * Simulates the robot's movement based on the given commands and obstacles.
     * 
     * @param commands  An array of commands where -2 represents a left turn, -1 represents a right turn,
     *                  and a positive integer represents the number of steps to move forward.
     * @param obstacles A 2D array of obstacles where each obstacle is a point on the coordinate plane.
     * @return The maximum distance traveled by the robot.
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        // Initialize the directions
        /**
         * An array of directions where each direction is represented as a pair of integers (x, y).
         * The directions are: North (0, 1), East (1, 0), South (0, -1), West (-1, 0).
         */
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Initialize the current direction and position
        /**
         * The current direction of the robot (0: North, 1: East, 2: South, 3: West).
         */
        int dir = 0;
        /**
         * The current position of the robot (x, y).
         */
        int x = 0, y = 0;
        
        // Initialize the maximum distance
        /**
         * The maximum distance traveled by the robot.
         */
        int maxDistance = 0;
        
        // Create a set to store the obstacles for efficient lookup
        /**
         * A set of obstacles where each obstacle is represented as a string in the format "x,y".
         */
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }
        
        // Iterate through the commands
        for (int command : commands) {
            // If the command is -2, turn left
            if (command == -2) {
                /**
                 * Update the current direction by turning left.
                 */
                dir = (dir + 3) % 4;
            }
            // If the command is -1, turn right
            else if (command == -1) {
                /**
                 * Update the current direction by turning right.
                 */
                dir = (dir + 1) % 4;
            }
            // If the command is a positive number, move forward
            else {
                /**
                 * Move the robot forward by the given number of steps.
                 */
                for (int i = 0; i < command; i++) {
                    int newX = x + directions[dir][0];
                    int newY = y + directions[dir][1];
                    
                    // Check if the new position is an obstacle
                    if (obstacleSet.contains(newX + "," + newY)) {
                        /**
                         * If the new position is an obstacle, stop moving.
                         */
                        break;
                    }
                    
                    // Update the position
                    x = newX;
                    y = newY;
                }
            }
            
            // Update the maximum distance
            maxDistance = Math.max(maxDistance, x * x + y * y);
        }
        
        return maxDistance;
    }
}
