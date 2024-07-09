
class Solution {
     public double averageWaitingTime(int[][] customers) {
        double idletime = 1.0;
        double avg = 0.0;
        double totalwaittime = 0;
        for(int customer[]: customers){
            if(idletime <= customer[0]){
                idletime = customer[0] + customer[1];
            }else{
                idletime += customer[1];
            }
            totalwaittime += idletime - (double)customer[0];
             avg = totalwaittime/customers.length;
        }
        return avg;
    }
}

// documentation
// This method iterates through each customer in the customers array. For each customer, 
//   it updates the idletime variable based on whether the customer arrives before or after the current idletime.
//   The totalwaittime is then updated by adding the difference between the idletime and the customer's arrival time.
//   Finally, the average waiting time is calculated by dividing the totalwaittime by the number of customers.
