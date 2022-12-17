import java.util.Arrays;
public class BlueAstronaut extends Player implements Crewmate{
    private int numTasks;
    private int taskSpeed;

    public BlueAstronaut(String name) {
        this(name, 15, 6, 10);
    }
    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public void emergencyMeeting() {
        if (!isFrozen()) {
            Player[] players = Player.getPlayers();
            Arrays.sort(players);
            for(int index = players.length - 1; index >= 1; index--) {
                if (!players[index].isFrozen()){
                    players[index].setFrozen(true);
                    gameOver();
                    break;
                }                
            }
        }
    }
    public void completeTask() {
        int oldNumTasks = numTasks;
        if (!isFrozen() && numTasks > 0) {
            numTasks = taskSpeed > 20 ? numTasks - 2: numTasks - 1;
            if (numTasks <= 0) {
                numTasks = 0;
                System.out.println("I have completed all my tasks");
                setSusLevel(Math.round(getSusLevel() * 0.5F));
            }
        }
    }
    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut blueAstronaut = (BlueAstronaut)o;
            if (blueAstronaut.getName().equals(getName())
             && blueAstronaut.isFrozen() == isFrozen() 
             && blueAstronaut.getSusLevel() == getSusLevel() 
             && blueAstronaut.getNumTasks() == numTasks
             && blueAstronaut.getTaskSpeed() == taskSpeed ) {
                return true;
            }
        }
        return false;
    }
    public String toString() {
        String message = super.toString() + " I have " + numTasks + " left over.";
        return getSusLevel() > 15 ? message.toUpperCase(): message;
    }
    public int getNumTasks() {
        return numTasks;
    }
    public int getTaskSpeed() {
        return taskSpeed;
    }

    public static void main(String[] args){
        BlueAstronaut ryota1 = new BlueAstronaut("ryota1", 5, 10, 21);
        BlueAstronaut ryota2 = new BlueAstronaut("ryota2", 30, 10, 15);
        ryota1.completeTask();
        ryota1.emergencyMeeting();
        System.out.println(ryota1);
        ryota2.completeTask();
        System.out.println(ryota2);
        System.out.println("ryota1 and ryota2: " + ryota2.equals(ryota1));
        System.out.println("ryota1 and ryota1: " + ryota1.equals(ryota1));       
    }
}