import java.util.Random;

public class randomInteger {
    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        //Generate a random integer between 0 (inclusive) and 1 (exclusive)
        int randomInt = rand.nextInt(10);
        System.out.println("Random integer: "+ randomInt);

        //Generate a random double between 0 (inclusive) and 1 (exclusive)
        double randomDouble = rand.nextDouble();        
        System.out.println("Random double: "+ randomDouble);
    }
}
