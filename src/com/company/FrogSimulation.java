package com.company;

//The method hopDistance() is implemented for you and the main in right in the class to make it simpler.
public class FrogSimulation
{
    /** Distance, in inches, from the starting position to the goal. */
    private int goalDistance;
    /** Maximum number of hops allowed to reach the goal. */
    private int maxHops;
    private int currentDistance = 0;
    Main newC = new Main();
    int[] testHops = newC.returnTestHops();
    int nextHopIndex = newC.returnTestIndex();
    /** Constructs a FrogSimulation where dist is the distance, in inches, from the starting
     * position to the goal, and numHops is the maximum number of hops allowed to reach the goal.
     * Precondition: dist > 0; numHops > 0
     */
    public FrogSimulation(int dist, int numHops)
    {
        maxHops = numHops;
        goalDistance = dist;
    }

    /** Returns an integer representing the distance, in inches, to be moved when the frog hops.
     */

    private int hopDistance()
    {
        int hop = testHops[nextHopIndex];
        nextHopIndex++;
        if (nextHopIndex >= testHops.length) {
            nextHopIndex = 0;
        }
        return hop;
    }

/********************** Part (a) *************************/

    /** Simulates a frog attempting to reach the goal as described in part (a).
     * Returns true if the frog successfully reached or passed the goal during the simulation;
     * false otherwise.
     */
    public boolean simulate()
    {
        for(int i = 0; i < maxHops; i++) {
            currentDistance += hopDistance();
        }
        if(currentDistance >= goalDistance)
        {
            currentDistance = 0;
            return true;
        }
        else
        {
            currentDistance = 0;
            return false;
        }
    }

/********************** Part (b) *************************/

    /** Runs num simulations and returns the proportion of simulations in which the frog
     * successfully reached or passed the goal.
     * Precondition: num > 0
     */
    public double runSimulations(int num)
    {
        int wins = 0;
        for(int i = 0; i < num; i++)
        {
            if(simulate())
            {
                wins++;
            }
        }
        return (double)wins/num;
    }
}

