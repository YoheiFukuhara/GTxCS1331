import java.util.Arrays;
public class Gameplay{
   public static void main(String[] args){
        BlueAstronaut blueBob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut blueHeath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut blueAlbert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut blueAngel = new BlueAstronaut("Angel", 0, 1, 0);
        RedAstronaut redLiam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut redSuspicious = new RedAstronaut("Suspicious Person", 100, "expert");
        System.out.println("-----1-----");
        redLiam.sabotage(blueBob);
        System.out.println(blueBob);
        System.out.println("-----2-----");
        redLiam.freeze(redSuspicious);
        System.out.println(redSuspicious);
        System.out.println("-----3-----");
        redLiam.freeze(blueAlbert);
        System.out.println(redLiam);
        System.out.println(blueAlbert);
        System.out.println("-----4-----");
        blueAlbert.emergencyMeeting();
        System.out.println("-----5-----");
        redSuspicious.emergencyMeeting();
        System.out.println("-----6-----");
        blueBob.emergencyMeeting();
        System.out.println(redSuspicious);
        System.out.println("-----7-----");
        blueHeath.completeTask(); 
        System.out.println(blueHeath);
        System.out.println("-----8-----");
        blueHeath.completeTask(); 
        System.out.println(blueHeath);
        System.out.println("-----9-----");
        blueHeath.completeTask(); 
        System.out.println(blueHeath);
        System.out.println("-----10-----");
        redLiam.freeze(blueAngel);
        System.out.println(blueAngel);
        System.out.println(redLiam);
        System.out.println("-----11-----");
        for (int i = 0; i < 2; i++) {
            redLiam.sabotage(blueBob); 
            System.out.println(blueBob);
        }
        System.out.println("-----12-----");
        redLiam.freeze(blueBob);
        System.out.println(blueBob);
        if (args.length == 0) {
            System.out.println("-----13-----");
            blueAngel.emergencyMeeting();
            System.out.println(redLiam);       
        } else {
            System.out.println("-----14-----");
            for (int i = 0; i < 5; i++) {
                redLiam.sabotage(blueHeath); 
                System.out.println(blueHeath);
            }
            System.out.println("-----15-----");
            redLiam.freeze(blueHeath);
        }
    }
}