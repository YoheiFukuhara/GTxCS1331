import java.util.Arrays;
public class RedAstronaut extends Player implements Impostor{
    private String skill; //inexperienced, experienced, expert

    public RedAstronaut(String name) {
        this(name, 15, "experienced");
    }
    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill.toLowerCase();
    }
    public void emergencyMeeting() {
        if (!isFrozen()) {
            Player[] players = Player.getPlayers();
            Arrays.sort(players);
            for(int index = players.length - 1; index >= 1; index--) {
                System.out.println(players[index]);
                if (!players[index].isFrozen() && !(equals(players[index]))){
                    int delta = players[index].compareTo(players[index-1]);
                    if (delta == 0) {
                        break;
                    } else if (delta > 0) {
                        players[index].setFrozen(true);
                        gameOver();
                        break;
                    }
                }                
            }
        }
    }
    public void freeze(Player p) {
        if (!isFrozen() && !(p instanceof RedAstronaut)) {
            if (getSusLevel() < p.getSusLevel()) {
                p.setFrozen(true);
            } else {
                setSusLevel(getSusLevel() * 2);
            }
        }
        gameOver();
    }
    public void sabotage(Player p) {
        if (!isFrozen() && !p.isFrozen() && !(p instanceof RedAstronaut)) {
            float ratio = getSusLevel() < 20 ? 1.5F: 1.25F;
            p.setSusLevel((int)(p.getSusLevel() * ratio));
        }
    }
    public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut redAstronaut = (RedAstronaut)o;
            if (redAstronaut.getName().equals(getName())
             && redAstronaut.isFrozen() == isFrozen() 
             && redAstronaut.getSusLevel() == getSusLevel()
             && redAstronaut.getSkill().equals(getSkill()) ) {
                return true;
            }
        }
        return false;
    }
    public String getSkill() {
        return skill;
    }
    public String toString() {
        String message = super.toString() + " I am an " + getSkill() + " player!";
        return getSusLevel() > 15 ? message.toUpperCase(): message;
    }
    public static void main(String[] args){
        RedAstronaut ryota1 = new RedAstronaut("ryota1", 4, "expert");
        RedAstronaut ryota2 = new RedAstronaut("ryota2", 4, "expert");
        ryota2.sabotage(ryota1);
        ryota2.setSusLevel(22);
        ryota2.sabotage(ryota1);
        ryota2.emergencyMeeting();
        System.out.println("ryota1 and ryota2: " + ryota2.equals(ryota1));
        System.out.println("ryota1 and ryota1: " + ryota1.equals(ryota1));
        System.out.println(ryota1);
        System.out.println(ryota2);
    }
}