package project4;
import java.util.Random;
/**
 * Ryan Alexiadis 
 * Prof. Bible 
 * Project 4
 *
 * Infestation
 * 
 * Comp. Sci. 111 
 * 4-20-15
 *
 */
public class Infestation {

    static int turns = 0;
    static int agentCount, trueagentcount;                  //agentcount is for array, true agent count keeps track of total agents
    static int humanCount = 203323;
    static Random r = new Random();                         //random object for tie-breaker in 'battle'

    public static void main(String[] args) {

        Human[] humanArray = new Human[203323];                // human array

        for (int i = 0; i < humanCount; i++) {
            humanArray[i] = new Human();
        }                                                    //create array of humans 203323 total

        Agent[] agentArray = new Agent[203323];

        agentCount = 1;
        trueagentcount = 1;                                     //start counters

        agentArray[0] = new Agent();                            //create single agent object.... Agent 0
        agentArray[0].setID(agentCount - 1);

        while (humanCount > 0 && trueagentcount > 0) {                //loop until one species is extinct

            for (int k = 0; k < agentCount; k++) {
                if (!(agentArray[k].getID().equals("dead"))) {
                    agentArray[k].move();                           //before each turn loop through all agents and move them randomly, unless dead
                }
            }
                        turns++;           
            for (int j = 0; j < agentCount && trueagentcount > 0; j++) {          //looping through all agents

                
                if (!(agentArray[j].getID().equals("dead"))) {          //checking to see if agent is dead, if so, skip to next agent

                    int x = agentArray[j].getX();
                    int y = agentArray[j].getY();

                    for (int i = 0; i < humanCount; i++) {           //looping through all humans to check xy match
                        
                        if (x == humanArray[i].getX() && y == humanArray[i].getY() && !(agentArray[j].getID().equals("dead"))) {       //if they are in same xy as agent, battle
                            
                            agentArray[j].attack();
                            
                            if (humanArray[i].attack() == agentArray[j].getAttack()) {         //if Attack powers are equal, flip coin
                                int choice = r.nextInt(2);

                                if (choice == 0) {                                   //0 = agent win, decrememnt human count and add 2 agents
                                    humanArray[i].setName("dead");
                                    humanArray[i].setX(0);
                                    humanArray[i].setY(0);
                                    humanCount--;

                                    agentArray[agentCount] = new Agent();
                                    agentArray[agentCount].setID(agentCount - 1);
                                    agentCount++;
                                    trueagentcount++;
                                    agentArray[agentCount] = new Agent();
                                    agentArray[agentCount].setID(agentCount - 1);
                                    agentCount++;
                                    trueagentcount++;

                                    System.out.println(agentArray[j].toString());

                                } else {                                            //1 = human win, decrement true agent count
                                    agentArray[j].setID("dead");
                                    agentArray[j].setX(0);
                                    agentArray[j].setY(0);
                                    trueagentcount--;

                                    System.out.println(humanArray[i].toString());       

                                }
                            }
                            
                            if (humanArray[i].attack() > agentArray[j].getAttack()) {      //human win, same as above

                                agentArray[j].setID("dead");
                                agentArray[j].setX(0);
                                agentArray[j].setY(0);
                                trueagentcount--;

                                System.out.println(humanArray[i].toString());
                            }

                            if (humanArray[i].attack() < agentArray[j].getAttack()) {          //agent win, same as above case

                                humanArray[i].setName("dead");
                                humanArray[i].setX(0);
                                humanArray[i].setY(0);
                                humanCount--;

                                agentArray[agentCount] = new Agent();
                                agentArray[agentCount].setID(agentCount - 1);
                                agentCount++;
                                trueagentcount++;
                                agentArray[agentCount] = new Agent();
                                agentArray[agentCount].setID(agentCount - 1);
                                agentCount++;
                                trueagentcount++;

                                System.out.println(agentArray[j].toString());

                            }
                        }
                    }
                }      
            }
        }
        
        /*
        when one of the species is extinct, then print the results
        who won?
        with human casualties
        and total amounts of agents left, if they win
        */
        
        
        if (humanCount <= 0) {
            System.out.println("\n\nAgents win and wiped out the entirety of Santa Clarita!\n");

        }
        
        if (trueagentcount <= 0) {
            System.out.println("\nHumans have wiped out the agent species and are safe to fight another day\n");
        }
        
        int deadhuman = 203323 - humanCount;
        System.out.println("Human count: " + humanCount);
        System.out.println("Total dead humans: " + deadhuman);
        System.out.println("\nAgent count: " + trueagentcount);

        System.out.println("Turns/Days = " + turns);

    }
}